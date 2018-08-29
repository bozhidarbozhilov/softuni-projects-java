package logger.models.files;


public class LogFile implements File {
    StringBuilder file;

    public LogFile() {
        this.file = new StringBuilder();
    }

    public void write(String logMessage){
        this.file.append(logMessage).append(System.lineSeparator());
    }

    public int getFileSize(){
        return this.file.chars().filter(_char-> (_char>64 && _char<91) || (_char>96 && _char<123)).sum();
    }
}
