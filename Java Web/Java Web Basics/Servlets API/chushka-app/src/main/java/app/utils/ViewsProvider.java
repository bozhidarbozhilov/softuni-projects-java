package app.utils;

import java.io.IOException;

public interface ViewsProvider {
    String view(String viewName) throws IOException;
}
