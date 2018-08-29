package logger.contollers;

import logger.models.appenders.Appender;
import logger.models.appenders.ConsoleAppender;
import logger.models.appenders.FileAppender;
import logger.models.enums.ReportLevel;
import logger.models.files.File;
import logger.models.files.LogFile;
import logger.models.layouts.Layout;
import logger.models.layouts.SimpleLayout;
import logger.models.layouts.XmlLayout;
import logger.models.loggers.Logger;
import logger.models.loggers.MessageLogger;

import java.util.Arrays;

public class LoggerController {
    private Appender[] appenders;
    private int appendersArrayIndex;
    private Logger logger;
    private Layout layout = null;
    private Appender appender;
    private ReportLevel reportLevel;

    public LoggerController(int appendersCount) {
        this.appenders = new Appender[appendersCount];
        this.logger = null;
        this.layout = null;
        this.appender = null;
        this.reportLevel = null;
        this.appendersArrayIndex = 0;
    }

    public void createAppender(String appenderType, String layoutType, String reportLevelType) {

        switch (layoutType) {
            case "SimpleLayout":
                this.layout = new SimpleLayout();
                break;
            case "XmlLayout":
                this.layout = new XmlLayout();
            default:
                break;
        }

        switch (appenderType) {
            case "ConsoleAppender":
                this.appender = new ConsoleAppender(layout);
                break;
            case "FileAppender":
                this.appender = new FileAppender(layout);
                File file = new LogFile();
                ((FileAppender) appender).setFile(file);
                break;
            default:
                break;
        }
        switch (reportLevelType) {
            case "WARNING":
                this.appender.setReportLevel(ReportLevel.WARNING);
                break;
            case "ERROR":
                this.appender.setReportLevel(ReportLevel.ERROR);
                break;
            case "CRITICAL":
                this.appender.setReportLevel(ReportLevel.CRITICAL);
                break;
            case "FATAL":
                this.appender.setReportLevel(ReportLevel.FATAL);
                break;
            case "INFO":
            default:
                this.appender.setReportLevel(ReportLevel.INFO);
                break;
        }
        this.appenders[this.appendersArrayIndex++] = appender;
    }

    public void createLogger(){
        this.logger = new MessageLogger(this.appenders);
    }


    public void setLogger(String inputStr) {
        String[] tokens = inputStr.split("\\|");
        switch (tokens[0]) {
            case "WARNING":
                logger.logWarning(tokens[1], tokens[2]);
                break;
            case "ERROR":
                logger.logError(tokens[1], tokens[2]);
                break;
            case "CRITICAL":
                logger.logCritical(tokens[1], tokens[2]);
                break;
            case "FATAL":
                logger.logFatal(tokens[1], tokens[2]);
                break;
            default:
                logger.logInfo(tokens[1], tokens[2]);
                break;
        }
    }

    public void loggerInfo(){
        System.out.println("Logger info");
        Arrays.stream(this.appenders).forEach(appender -> System.out.println(appender.toString()));
    }
}
