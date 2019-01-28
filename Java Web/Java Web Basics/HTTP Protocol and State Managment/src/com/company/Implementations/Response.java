package com.company.Implementations;

import com.company.Contracts.HttpRequest;
import com.company.Contracts.HttpResponse;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Response implements HttpResponse {
    private HttpRequest request;
    private Map<String, String> headers;
    private int statusCode;
    private String statusPhrase;
    private String stringContent;
    private byte[] content;
    private List<String> validUrls;

    public Response(List<String> validUrls, HttpRequest request){
        this.validUrls = validUrls;
        this.request = request;
        this.headers = new HashMap<>();
        this.generateResponse();
    }

    public Response(HttpRequest request) {
        this.request = request;
        this.headers = new HashMap<>();
    }

    @Override
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    @Override
    public int getStatusCode() {
        return this.statusCode;
    }

    @Override
    public byte[] getContent() {
        return this.content;
    }

    @Override
    public byte[] getBytes() {
        StringBuilder returnResponse = new StringBuilder();
        returnResponse.append("HTTP/1.1").append(" ")
                .append(this.getStatusCode()).append(" ").append(this.getStatusPhrase())
                .append(System.lineSeparator());
        this.getHeaders().entrySet().forEach(header->
                returnResponse.append(header.getKey()).append(": ").append(header.getValue())
                        .append(System.lineSeparator()));
        returnResponse.append(System.lineSeparator());
        returnResponse.append(this.getStringContent());

        return returnResponse.toString().getBytes();
    }

    public String getStatusPhrase() {
        return statusPhrase;
    }

    public void setStatusPhrase(String statusPhrase) {
        this.statusPhrase = statusPhrase;
    }

    private String getStringContent() {
        return stringContent;
    }

    private void setStringContent(String stringContent) {
        this.stringContent = stringContent;
    }

    @Override
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public void addHeader(String header, String value) {
        this.headers.put(header,value);
    }

    private void generateResponse(){
        fillResponseHeaders();
        if (!this.validUrls.contains(this.request.getRequestUrl())) {
            this.setStatusCode(404);
            this.setStatusPhrase("Not Found");
            this.setStringContent("The requested functionality was not found.");
            this.setContent(this.getStringContent().getBytes());
            return;
        }

        if (!this.request.getHeaders().containsKey("Authorization")) {
            this.setStatusCode(401);
            this.setStatusPhrase("Unauthorized");
            this.setStringContent("You are not authorized to access the requested functionality.");
            this.setContent(this.getStringContent().getBytes());
            return;
        }
        if (this.request.getMethod().equals("POST")) {
            if(this.request.getBodyParameters().size() == 0){
                this.setStatusCode(400);
                this.setStatusPhrase("Unauthorized");
                this.setStringContent
                        ("There was an error with the requested functionality due to malformed request.");
                this.setContent(this.getStringContent().getBytes());
            }
            StringBuilder responseBody = new StringBuilder();
            responseBody.append("Greeting ")
                    .append(decryptUsername(this.request.getHeaders().get("Authorization")))
                    .append("! You successfully created ")
                    .append(this.request.getBodyParameters().entrySet().iterator().next().getValue())
                    .append(" with ");
            this.request.getBodyParameters().entrySet().stream().skip(1).forEach(param->
                    responseBody.append(param.getKey()).append(" - ").append(param.getValue())
                            .append(System.lineSeparator()));
            responseBody.replace(responseBody.lastIndexOf(System.lineSeparator()),responseBody.length(), ".");
            this.setStatusCode(200);
            this.setStatusPhrase("OK");
            this.setStringContent(responseBody.toString());
            this.setContent(this.getStringContent().getBytes());
        }else if(this.request.getMethod().equals("GET")){
            String getResponseBody = "Greeting "
                    +decryptUsername(this.request.getHeaders().get("Authorization"))+"!";
            this.setStatusCode(200);
            this.setStatusPhrase("OK");
            this.setStringContent(getResponseBody);
            this.setContent(this.getStringContent().getBytes());
        }

    }

    private static String decryptUsername(String cryptedUsername) {
        String crypted = cryptedUsername.split("\\s")[1];
        byte[] decrypt = Base64.getDecoder().decode(crypted);
        return new String(decrypt, StandardCharsets.UTF_8);
    }

    private void fillResponseHeaders() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.addHeader("Date", LocalDate.now().format(dtf));
        if (this.request.getHeaders().containsKey("Host")) {
            this.addHeader("Host", this.request.getHeaders().get("Host"));
        }
        if (this.request.getHeaders().containsKey("Content-Type")) {
            this.addHeader("Content-Type", this.request.getHeaders().get("Content-Type"));
        }
    }

}
