package logger.models.appenders;

import logger.models.enums.ReportLevel;

public interface Appender {
    void appendMessage(String dateTime, ReportLevel reportLevel, String message);
    void setReportLevel(ReportLevel reportLevel);
}
