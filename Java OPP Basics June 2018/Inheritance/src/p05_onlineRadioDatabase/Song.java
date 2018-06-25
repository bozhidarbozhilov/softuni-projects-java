package p05_onlineRadioDatabase;

import p05_onlineRadioDatabase.exceptions.*;
import static p05_onlineRadioDatabase.constants.ExceptionsConstants.*;

public class Song {
    private String artist;
    private String name;
    private SongLength length;

    public Song(String artist, String name){
        this.setArtist(artist);
        this.setName(name);
    }

    private void setArtist(String artist) {
        if(artist.length()<3 || artist.length()>20){
            throw new InvalidArtistNameException(INVALID_ARTIST_NAME_EXCEPTION);
        }
        this.artist = artist;
    }

    private void setName(String name) {
        if(name.length()<3 || name.length()>30){
            throw new InvalidSongNameException(INVALID_SONG_NAME_EXCEPTION);
        }
        this.name = name;
    }

    protected SongLength getLength(){
        return this.length;
    }

    protected void setLength(SongLength length){
        this.length = length;
    }

}
