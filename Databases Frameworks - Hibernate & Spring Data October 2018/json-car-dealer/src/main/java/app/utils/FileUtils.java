package app.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.Basic;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;

@Component
public class FileUtils {

    public FileUtils() {
    }

    public String readFromFile(String fileName) throws FileNotFoundException {
        InputStream file = getFileFromResource(fileName);
        Scanner scanner = new Scanner(file);
        StringBuilder result = new StringBuilder();

        while(scanner.hasNextLine()){
            result.append(scanner.nextLine());
        }
        scanner.close();
        return result.toString();
    }

    public void writeToFile(String content, File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(content);
        writer.close();
    }

    private InputStream getFileFromResource(String fileName) {
        InputStream stream = FileUtils.class.getResourceAsStream(fileName);
        return stream;
    }

}
