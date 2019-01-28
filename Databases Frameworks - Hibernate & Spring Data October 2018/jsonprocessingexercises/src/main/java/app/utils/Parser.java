package app.utils;

import java.io.FileNotFoundException;

public interface Parser {
    public <T> T importFromFile(Class<T> klass, String file) throws FileNotFoundException;

    public String exportToFile(Object object);
}
