package com.company.Implementations;

import com.company.Contracts.HttpRequest;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Request implements HttpRequest {
    private String method;
    private String requestURL;
    private String httpVersion;
    private Map<String, String> headers;
    private Map<String, String> bodyParameters;
    private String request;
    private List<HttpCookie> cookies;

    public Request(String request) throws IOException {
        this.setRequest(request);
        this.headers = new HashMap<>();
        this.bodyParameters = new LinkedHashMap<>();
        this.cookies = new ArrayList<>();
        this.parse();
        this.parseCookies();
    }

    private void setRequest(String request) {
        this.request = request;
    }

    @Override
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    @Override
    public Map<String, String> getBodyParameters() {
        return this.bodyParameters;
    }

    @Override
    public String getMethod() {
        return this.method;
    }

    @Override
    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String getRequestUrl() {
        return this.requestURL;
    }

    @Override
    public void setRequestUrl(String requestUrl) {
        this.requestURL = requestUrl;
    }

    @Override
    public void addHeader(String header, String value) {
        this.headers.put(header, value);
    }

    @Override
    public void addBodyParameter(String parameter, String value) {
        this.bodyParameters.put(parameter, value);
    }

    @Override
    public boolean isResource() {
        return requestURL.contains(".");
    }

    private void parse() throws IOException {

        List<String> requestToList = Arrays.asList(this.request.split("\r\n"));


        String[] requestLine = requestToList.get(0).split("\\s");
        this.method = requestLine[0].trim();
        this.requestURL = requestLine[1].trim();
        this.httpVersion = requestLine[2].trim();

        requestToList.stream().skip(1).forEach(line -> {
            String[] headerParams = line.split(": ");
            if (headerParams.length == 2) {
                this.addHeader(headerParams[0], headerParams[1]);

            } else {
                if (!line.isEmpty()) {
                    String[] bodyTokens = line.split("&");
                    for (String row : bodyTokens) {
                        String[] paramElements = row.split("=");
                        this.addBodyParameter(paramElements[0], paramElements[1]);
                    }
                }
            }

        });
    }

    private void addCookie(HttpCookie cookie) {
        this.cookies.add(cookie);
    }

    public Iterable<HttpCookie> getCookies() {
        return this.cookies;
    }


    private void parseCookies() {
        String cookies = this.headers.get("Cookie");

        if (cookies !=null && !cookies.isEmpty()) {
            String[] cookiesKvp = cookies.split("; ");
            for (String cookieStatement : cookiesKvp) {
                String[] cookieTokens = cookieStatement.split("=");
                String cookieKey = cookieTokens[0];
                String cookieValue = cookieTokens[1];
                this.addCookie(new HttpCookie(cookieKey, cookieValue));
            }

        }
    }
}
