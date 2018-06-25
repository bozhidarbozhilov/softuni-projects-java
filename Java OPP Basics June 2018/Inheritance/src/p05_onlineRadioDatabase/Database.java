package p05_onlineRadioDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Database {
    private List<Song> songs;

    public Database(){
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song){
        this.songs.add(song);
    }

    protected List<Song> getSongs(){
        return Collections.unmodifiableList(this.songs);
    }

    public int getAllSongsDurationInSeconds(){
        int minutes = songs.stream().mapToInt(song -> song.getLength().getMinutes()*60).sum();
        int seconds = songs.stream().mapToInt(song->song.getLength().getSeconds()).sum();
        return minutes+seconds;
    }
}
