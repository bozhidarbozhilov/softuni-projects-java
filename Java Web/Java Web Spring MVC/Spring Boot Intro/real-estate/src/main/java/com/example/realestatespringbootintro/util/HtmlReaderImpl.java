package com.example.realestatespringbootintro.util;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class HtmlReaderImpl implements HtmlReader {
    @Override
    public String readHtmlFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
        StringBuilder htmlContent = new StringBuilder();

        String line = "";
        while((line=reader.readLine())!=null){
            htmlContent.append(line).append(System.lineSeparator());

        }
        return htmlContent.toString().trim();
    }
}
