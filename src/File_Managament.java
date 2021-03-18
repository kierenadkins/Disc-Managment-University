import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;


public class File_Managament {

    private static BufferedReader getReader() throws FileNotFoundException {
        try{
            BufferedReader reader = new BufferedReader(new FileReader("Disc.csv")); //gets reader and returns to functions that call it
            return reader;

        }
       catch (Exception e){
            System.out.println("file cannot be found");
            return null;
       }
    }
    private static BufferedWriter getWriter() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Disc.csv")); //get writer and returns to functions that need it
        return writer;
    }


        public static ArrayList read() throws IOException {
        try {
            BufferedReader reader = getReader();
            String line;
            ArrayList<String> data = new ArrayList<String>();

            while ((line = reader.readLine()) != null) { //reads though every line until no lines left
                data.add(line);

            }
            for (int i = 1; i < data.size(); i++) {
                System.out.println(i + ") " + data.get(i)); //prints out values for the users to pick using a interger
            }
            reader.close();
            return data;
        }
        catch (Exception e){
            System.out.println("something went wrong");
            return null;
        }
        }
        

        public static void deletefile(){
            File file = new File("Disc.csv");
            if(file.delete()) //deletes a file
            {
                System.out.println("File deleted successfully");
            }
            else
            {
                System.out.println("Failed to delete the file");
            }
        }
    public static void renamefile(){
        Scanner sc = new Scanner(System.in);
        File file = new File("Disc1.csv");
        System.out.println("what would u like to rename file");
        String x = sc.next();

        if(file.renameTo(new File(x + ".csv")))
        {
            System.out.println("rename success");
        }
        else
        {
            System.out.println("Failed to delete the file");
        }
    }


        public static void Delete() throws IOException {
        try {
            ArrayList<String> data = read();
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter int for the record u want to delete");
            int deletion = sc.nextInt();
            data.remove(deletion);
            deletefile();
            BufferedWriter writer = getWriter();
            for (int i = 0; i < data.size(); i++) {
                writer.write(data.get(i));
                writer.newLine();
            }
            writer.close();
            System.out.println("record deleted");
        }
        catch(Exception e){
            System.out.println("error...." + e);
        }
        }
    public static void SearchByTitle()throws Exception{
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("please enter the name");
            String search = sc.nextLine(); // user inputs there search

            BufferedReader reader = getReader(); //gets file location from getreader function
            String line; //stores line of result
            while ((line = reader.readLine()) != null) { //reads though every line until no lines left
                String[] values = line.split(","); // seperates data
                if (values[0].equals(search.toLowerCase())) {
                    System.out.println(line); //prints out all records same name, eg sequals
                }

            }

            reader.close();
        }
        catch (Exception e){
            System.out.println("Something went wrong please try again");
        }

    }



    public static void AmountofLine(){
        try {
            BufferedReader reader = getReader();
            int lines = 0; //stores how many records there are
            while (reader.readLine() != null) lines++; // by looping through and counting entries
            reader.close();
            reverse(getReader(), lines);

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void reverse(BufferedReader reader, int lines) {
        try {
            String reverse = reader.readLine(); //stores record into read
            if (lines != 0) { //
                reverse(reader, lines - 1); //recursive loops through each record backwards until lines is equal to 0
                System.out.println(reverse);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}