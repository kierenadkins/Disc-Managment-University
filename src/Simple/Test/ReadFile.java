package Simple.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile{
    public static String read(BufferedReader reader) throws IOException {
        try {
            String line;
            ArrayList<String> data = new ArrayList<String>();

            while ((line = reader.readLine()) != null) { //reads though every line until no lines left
                data.add(line);

            }
            for (int i = 1; i < data.size(); i++) {
                System.out.println(data.get(i)); //prints out values
            }
            reader.close();
            return "File read";
        }
        catch (Exception e){
            return "file not read";
        }
    }
}

