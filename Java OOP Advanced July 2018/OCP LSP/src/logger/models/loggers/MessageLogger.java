package logger.models.loggers;

import logger.models.appenders.Appender;
import logger.models.enums.ReportLevel;

import java.util.Arrays;
import java.util.List;

public class MessageLogger implements Logger {
    private List<Appender> appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = Arrays.asList(appenders);
    }

    @Override
    public void logInfo(String dateTime, String message) {
        for (Appender appender : this.appenders) {
            appender.appendMessage(dateTime, ReportLevel.INFO, message);
        }

    }

    @Override
    public void logWarning(String dateTime, String message) {
        for (Appender appender : this.appenders) {
            appender.appendMessage(dateTime, ReportLevel.WARNING, message);
        }
    }

    @Override
    public void logError(String dateTime, String message) {
        for (Appender appender : this.appenders) {
            appender.appendMessage(dateTime, ReportLevel.ERROR, message);
        }
    }

    @Override
    public void logCritical(String dateTime, String message) {
        for (Appender appender : this.appenders) {
            appender.appendMessage(dateTime, ReportLevel.CRITICAL, message);
        }
    }

    @Override
    public void logFatal(String dateTime, String message) {
        for (Appender appender : this.appenders) {
            appender.appendMessage(dateTime, ReportLevel.FATAL, message);
        }
    }


}
