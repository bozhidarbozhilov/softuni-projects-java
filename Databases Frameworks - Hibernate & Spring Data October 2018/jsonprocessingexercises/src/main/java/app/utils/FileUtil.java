package app.utils;

import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@Component
public class FileUtil {
    public String readFromFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();

        while(scanner.hasNext()){
            sb.append(scanner.nextLine());
        }
        return sb.toString();
    }

    public void writeToFile(String content, String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.write(content);
        writer.flush();
        writer.close();
    }

}
