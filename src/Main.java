import java.io.*;

import java.util.Scanner;
public class Main {
    /*Test
    valid inputs work correctly 1-6
    invaid inputs output incorrect value and repeates the menu
    menu contiunues to opperate until the user presses 6 no matter how many times it is used
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean Menu = true;
        do {
            System.out.println(" Information System");
            System.out.println("=====================");
            System.out.println("1) add new music CD details");
            System.out.println("2) add new game disc details");
            System.out.println("3) remove a specific disc from the list");
            System.out.println("4) search for a specific disc by title");
            System.out.println("5) display details");
            System.out.println("6) display the details of the list in reverse order");
            System.out.println("7) exit");
            
            int choice = sc.nextInt();
            //uses a switch to display a menu and the user able to choice a function to call
            switch (choice) { //Switch to chose a function according to the text above
                case 1 -> add_new(choice);
                case 2 -> add_new(choice);
                case 3 -> File_Managament.Delete();
                case 4 -> File_Managament.SearchByTitle();
                case 5 -> File_Managament.read();
                case 6 -> File_Managament.AmountofLine();
                case 7 -> Menu = false;
                default -> System.out.println("incorrect value");
            }
        } while (Menu);

    }



    public static void add_new(int choice) {
        try {
            Scanner sc = new Scanner(System.in);
            String[] MGenre = {"Rock", "Pop", "Jazz", "Hip", "heavy", "country"}; //predifined list
            String[] GGenre = {"Shooter", "Action", "Arcade", "puzzle", "adventure", "open world"}; //predifined list

            System.out.println("please tell us the title"); //gets users input for title
            String Title = sc.nextLine();

            System.out.println("release date?"); //gets users input for release date
            int release = sc.nextInt();
            if (choice == 1) {
                add_new_musicCD(Title, release); //uses the choice from above to determine which disc functions we are going to
            } else if (choice == 2) {
                add_new_gameDisc(Title, release);
            }
        }
        catch (Exception e){
            System.out.println("the error is" + e); //catchs the error and prints what the error is
        }


    }
    public static String getgenre(String[] genres ){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < genres.length; i++) { //reads out list of genres which is passed from either the music function, or game
            System.out.println(i + ") " + genres[i]);
        }

        return genres[sc.nextInt()]; //returns the genre chocen by the user
    }

    public static int pegi(){
        Scanner sc = new Scanner(System.in);
        System.out.println("please choice a pegi age");
        int[] Pegi = {3, 7, 12, 15, 16, 18}; //predifined list
        for (int i = 0; i < Pegi.length; i++) { //reads out list
            System.out.println(i + ") " + Pegi[i]);
        }
        return Pegi[sc.nextInt()];
    }

    public static void writefile(Disc newdisc, String type){
        BufferedWriter writer = null;

        try{
            writer = new BufferedWriter(new FileWriter("Disc.csv", true)); //creates file and allows us to append values
            writer.write(newdisc.toString().toLowerCase() + "," + type); //lowers all values into lowercase and adds commas and type of disc to value
            writer.newLine(); //new line on the file
            writer.close(); //closes and saves file

        }
        catch(Exception e)
        {
            System.out.println("error");
        }
        finally{
            System.out.println("works");

        }

    }


    public static void add_new_musicCD(String Title, int release) {
        Scanner sc = new Scanner(System.in);
        String[] MGenre = {"Rock", "Pop", "Jazz", "Hip", "heavy", "country"}; //predifined list
        String type = "Music";
        try {
            System.out.println("please select a genre");
            String genre = getgenre(MGenre);
            System.out.println("artist name");
            String artist = sc.nextLine();
            System.out.println("number of songs produced");
            int num = sc.nextInt();
            System.out.println("duration of songs in seconds");
            int duration = sc.nextInt();
            Music newdisc = new Music(Title, genre, release, artist, num, duration);//creates instance
            writefile(newdisc, type);
        } catch (Exception e) {
            System.out.println("something went wrong");
        }

    }

    public static void add_new_gameDisc(String Title, int release) {
        String[] GGenre = {"Shooter", "Action", "Arcade", "puzzle", "adventure", "open world"};
        String[]Gplatform = {"playstation", "Xbox", "Pc", "Nintendo", "Other"};
        int[] Pegi = {3, 7, 12, 15, 16, 18}; //predifined list
        Scanner sc = new Scanner(System.in);
        String type = "Game";
        try {
          String Genre = getgenre(GGenre);
          int rating = pegi(); //had to create a new function to fetch defined list due to this requiring an int
          System.out.println("what is your platform?");
          String platform = getgenre(Gplatform);
          Game newdisc = new Game(Title, Genre, release, rating, platform);//creates instance
            System.out.println(newdisc.toString());
            writefile(newdisc, type);


        } catch (Exception e) {
            System.out.println("Something went wrong");}
        finally {
            System.out.println("the disc has been created");
        }
    }


}

