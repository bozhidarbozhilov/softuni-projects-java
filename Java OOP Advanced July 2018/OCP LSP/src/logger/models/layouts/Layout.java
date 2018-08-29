package logger.models.layouts;

public interface Layout {
    String defineFormat(String dateTime, String reportLevel, String message);
}
