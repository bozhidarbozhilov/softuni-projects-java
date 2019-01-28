package app.utils;

public interface Parser {
    <T> T importFromFile(Class<T> klass, String fileName);
    String exportToFile(Object object);
 }
