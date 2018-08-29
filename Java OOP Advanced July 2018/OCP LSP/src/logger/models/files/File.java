package logger.models.files;

public interface File {
    int getFileSize();
    void write(String logMessage);

}
