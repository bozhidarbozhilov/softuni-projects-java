package logger.models.appenders;

import logger.models.enums.ReportLevel;
import logger.models.layouts.Layout;

public abstract class BaseAppender implements Appender {
    private int appendedMessages;
    private Layout layout;
    private ReportLevel reportLevel;

    protected BaseAppender(Layout layout) {
        this.appendedMessages = 0;
        this.layout = layout;
    }

    protected Layout getLayout() {
        return layout;
    }

    public void setReportLevel(ReportLevel reportLevel){
        this.reportLevel = reportLevel;
    }

    protected ReportLevel getReportLevel(){
        return this.reportLevel;
    }

    protected int getAppendedMessages() {
        return this.appendedMessages;
    }

    protected void countAppendedMessages() {
        this.appendedMessages++;
    }

    @Override
    public String toString() {
        return String
                .format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d" ,
                        this.getClass().getSimpleName(),this.getLayout().getClass().getSimpleName(), this.getReportLevel().toString(), this.getAppendedMessages());
    }
}
