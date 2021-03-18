package Simple.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Search_By_Title {

    public BufferedReader getReader() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("Disc.csv"));
        return reader;
    }

    public static String SearchByTitle(String Search, BufferedReader reader) throws Exception {
        String resultRow = null;
        String line; //stores line of result
        while ((line = reader.readLine()) != null) { //reads though every line until no lines left
            String[] values = line.split(","); // seperates data
            if (values[0].equals(Search.toLowerCase())) {
                System.out.println(line); //prints out all records same name, eg sequals
                return line;
            }
        }

        reader.close();
        return "not found";
    }
}