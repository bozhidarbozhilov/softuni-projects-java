package p05_onlineRadioDatabase;

import p05_onlineRadioDatabase.exceptions.InvalidSongLengthException;
import p05_onlineRadioDatabase.exceptions.InvalidSongMinutesException;
import p05_onlineRadioDatabase.exceptions.InvalidSongSecondsException;

import static p05_onlineRadioDatabase.constants.ExceptionsConstants.INVALID_SONG_LENGTH_EXCEPTION;
import static p05_onlineRadioDatabase.constants.ExceptionsConstants.INVALID_SONG_MINUTES_EXCEPTION;
import static p05_onlineRadioDatabase.constants.ExceptionsConstants.INVALID_SONG_SECONDS_EXCEPTION;

public class SongLength {
    private int minutes;
    private int seconds;

    public SongLength(String songLength){
        this.parseLength(songLength);
    }
    private void parseLength(String songLength){
        String[] tokens = songLength.split(":");
        String minutes = tokens[0];
        String seconds = tokens[1];
        if(tokens.length !=2 || !minutes.matches("\\d+") || !seconds.matches("\\d+")){
            throw new InvalidSongLengthException(INVALID_SONG_LENGTH_EXCEPTION);
        }
        this.setMinutes(Integer.parseInt(minutes));
        this.setSeconds(Integer.parseInt(seconds));
    }

    protected int getMinutes(){
        return this.minutes;
    }
    private void setMinutes(int minutes) {
        if(minutes<0 || minutes>14){
            throw new InvalidSongMinutesException(INVALID_SONG_MINUTES_EXCEPTION);
        }
        this.minutes = minutes;
    }

    protected int getSeconds(){
        return this.seconds;
    }
    private void setSeconds(int seconds) {
        if(seconds<0||seconds>59){
            throw new InvalidSongSecondsException(INVALID_SONG_SECONDS_EXCEPTION);
        }
        this.seconds = seconds;
    }
}
