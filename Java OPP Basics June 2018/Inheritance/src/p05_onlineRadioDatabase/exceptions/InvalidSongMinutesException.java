package p05_onlineRadioDatabase.exceptions;

public class InvalidSongMinutesException extends InvalidSongLengthException {

    public InvalidSongMinutesException(String s){
        super(s);
    }
}
