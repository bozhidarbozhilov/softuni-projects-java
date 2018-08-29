package logger.models.loggers;

import logger.models.enums.ReportLevel;

public interface Logger {
    void logInfo(String dateTime, String message);
    void logWarning(String dateTime, String message);
    void logError(String dateTime, String message);
    void logCritical(String dateTime, String message);
    void logFatal(String dateTime, String message);
}
