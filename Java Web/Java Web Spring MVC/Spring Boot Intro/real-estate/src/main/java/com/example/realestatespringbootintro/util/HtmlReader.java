package com.example.realestatespringbootintro.util;

import org.springframework.stereotype.Component;

import java.io.IOException;

public interface HtmlReader {
    String readHtmlFile(String filePath) throws IOException;
}
