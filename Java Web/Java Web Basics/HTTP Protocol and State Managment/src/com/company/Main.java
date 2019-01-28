package com.company;

import com.company.Implementations.Request;
import com.company.Implementations.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        //List<String> validURLs = Arrays.asList(reader.readLine().split("\\s+"));
        StringBuilder request = new StringBuilder();

        //ParseHTTPRequest parsedRequest = new ParseHTTPRequest();
        String line = "";
        while ((line = reader.readLine()) != null && line.length() > 0) {
            request.append(line).append(System.lineSeparator());

        }
        request.append(System.lineSeparator());
        if ((line = reader.readLine()) != null && line.length() > 0) {
            request.append(line);
        }


        Request parsedRequest = new Request(request.toString());


        parsedRequest.getCookies().forEach(cookie->
                System.out.println(String.format("%s <-> %s", cookie.getKey(), cookie.getValue())));

    }

}
