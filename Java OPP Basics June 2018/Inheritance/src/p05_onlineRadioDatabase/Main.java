package p05_onlineRadioDatabase;

import p05_onlineRadioDatabase.exceptions.InvalidSongException;
import p05_onlineRadioDatabase.exceptions.InvalidSongLengthException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInput = Integer.parseInt(scanner.nextLine());
        Database database = new Database();

        while(numberOfInput-- > 0){
            String[] input = scanner.nextLine().split(";");

            String artist = input[0];
            String songName = input[1];
            String length = input[2];

            try{
                SongLength songLength = new SongLength(length);
                Song song = new Song(artist, songName);
                song.setLength(songLength);
                database.addSong(song);
                System.out.println("Song added.");
            }catch(InvalidSongException ise){
                System.out.println(ise.getMessage());
            }
            try{

            }catch (InvalidSongLengthException isl){
                System.out.println(isl.getMessage());
            }

        }
        System.out.println("Songs added: "+database.getSongs().size());

        String playListDuration = calcPlayListDuration(database.getAllSongsDurationInSeconds());
        System.out.println("Playlist length: "+playListDuration);
    }

    private static String calcPlayListDuration(int allSongsDurationInSeconds) {
        int hours = allSongsDurationInSeconds/3600;
        int minutes = (allSongsDurationInSeconds%3600)/60;
        int seconds = allSongsDurationInSeconds%60;

        return String.format("%dh %dm %ds", hours,minutes,seconds);
    }
}
