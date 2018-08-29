package logger.models.enums;

public enum ReportLevel {
    INFO, WARNING, ERROR, CRITICAL, FATAL;
    private ReportLevel reportLevel;

    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }
}
