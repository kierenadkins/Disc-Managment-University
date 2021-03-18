import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Game extends Disc {
    private int Rating;
    private String Platform;
    public Game(String Title, String Genre, int ReleaseDate, int rating, String platform) {
        super(Title, Genre, ReleaseDate);
        this.Rating = rating;
        this.Platform = platform;
    }

    public int getRating() {
        return Rating;
    }

    public String getPlatform() {
        System.out.println(Platform);
        return Platform;
    }

    @Override
    public String toString() {

        return getTitle()+ ", " + getReleaseDate() + ", "+getGenre() + ", "+ "Null"+", "+"Null"+", " + "Null" + ", " + Platform + ", " + Rating;
    }
}

