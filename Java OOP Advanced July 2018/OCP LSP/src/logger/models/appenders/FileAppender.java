package logger.models.appenders;

import logger.models.enums.ReportLevel;
import logger.models.files.File;
import logger.models.layouts.Layout;

public class FileAppender extends BaseAppender {
    private File file;


    public FileAppender(Layout layout) {
        super(layout);
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void appendMessage(String dateTime, ReportLevel reportLevel, String message) {
        if(super.getReportLevel().ordinal() <= reportLevel.ordinal()){
            file.write(super.getLayout().defineFormat(dateTime, reportLevel.toString(), message));
            super.countAppendedMessages();
        }

    }
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(super.toString());
        output.append(", File size: ").append(this.file.getFileSize());
        return output.toString();
    }
}
