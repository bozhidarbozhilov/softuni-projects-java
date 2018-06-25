package p05_onlineRadioDatabase.exceptions;

public class InvalidSongSecondsException extends InvalidSongLengthException {

    public InvalidSongSecondsException(String s){
        super(s);
    }
}
