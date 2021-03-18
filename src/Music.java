
public class Music extends Disc {
    private String Artist;
    private int NumberOfSongs;
    private int DurationOfSong;

    public Music(String Title, String Genre, int ReleaseDate, String artist, int numberOfSongs, int durationofsong) {
        super(Title, Genre, ReleaseDate);
        this.Artist = artist;
        this.NumberOfSongs = numberOfSongs;
        this.DurationOfSong = durationofsong;

    }
    public String getArtist(){ return Artist;}
    public int getNumberOfSongs(){
        return NumberOfSongs;
    }
    public int getDurationOfSong(){return DurationOfSong;}

    public String toString() {

        return  getTitle() +", " + getReleaseDate()+", " + getGenre()+ ", " + Artist+", " +   NumberOfSongs+ ", " + DurationOfSong+"S"+ ", "+ "Null"+", "+ "Null";
    }
}
