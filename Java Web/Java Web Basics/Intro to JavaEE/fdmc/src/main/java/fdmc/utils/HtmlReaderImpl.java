package fdmc.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HtmlReaderImpl implements HtmlReader {

    @Override
    public String readHtmlFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder result = new StringBuilder();

        String line = "";
        while(!(line = reader.readLine()).equals("</html>")){
            result.append(line).append(System.lineSeparator());
        }

        return result.toString();
    }
}
