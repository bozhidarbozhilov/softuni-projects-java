package logger.models.layouts;

public class SimpleLayout implements Layout {
    @Override
    public String defineFormat(String dateTime, String reportLevel, String message) {
        return String.format("%s - %s - %s", dateTime, reportLevel ,message);
    }
}
