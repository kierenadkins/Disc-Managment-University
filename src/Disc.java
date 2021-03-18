public class Disc {
        private String Title;
        private String Genre;
        private int ReleaseDate;

    public Disc(String Title, String Genre, int ReleaseDate){
        //constructor
        this.Title = Title;
        this.Genre = Genre;
        this.ReleaseDate = ReleaseDate;
    }


    public String getTitle() { return Title;}
    public String getGenre(){
        return Genre;
    }
    public int getReleaseDate(){return ReleaseDate;}

}

