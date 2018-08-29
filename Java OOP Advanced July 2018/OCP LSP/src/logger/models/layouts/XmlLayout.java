package logger.models.layouts;

public class XmlLayout implements Layout {
    @Override
    public String defineFormat(String dateTime, String reportLevel, String message) {
        StringBuilder outputLayout = new StringBuilder();

        outputLayout.append("<log>").append(System.lineSeparator())
                .append("\t").append("<date>").append(dateTime).append("</date>").append(System.lineSeparator())
                .append("\t").append("<level>").append(reportLevel).append("</level>").append(System.lineSeparator())
                .append("\t").append("<message>").append(message).append("</message>").append(System.lineSeparator())
                .append("</log>");
        return outputLayout.toString();
    }
}
