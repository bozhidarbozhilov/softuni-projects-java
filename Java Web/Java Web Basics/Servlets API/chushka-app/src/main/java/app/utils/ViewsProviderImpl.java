package app.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.stream.Collectors;

public class ViewsProviderImpl implements ViewsProvider {
    @Override
    public String view(String viewFilePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(viewFilePath));

        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
    }
}
