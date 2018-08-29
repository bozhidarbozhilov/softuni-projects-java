package logger.models.appenders;

import logger.models.enums.ReportLevel;
import logger.models.layouts.Layout;

public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void appendMessage(String dateTime, ReportLevel reportLevel, String message) {
        if(super.getReportLevel().ordinal() <= reportLevel.ordinal()){
            System.out.println(super.getLayout().defineFormat(dateTime, reportLevel.toString(), message));
            super.countAppendedMessages();
        }

    }


}
