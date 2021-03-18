package Simple.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Renamefile {

    public static String renamefile(String newPathname, String OldPathName) {
        Scanner sc = new Scanner(System.in);
        File file = new File(OldPathName); //function passes the oldpathname through

        if (file.renameTo(new File(newPathname + ".csv"))) { //renameto changes the name and adds .csv so user doesnt have to
            return "file renamed success"; //if successful
        } else {
            return "Failed to delete the file"; //if not successful
        }
    }
}
