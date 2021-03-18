package Simple.Test;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileTest {
    //purpose of the test is to see if the function can successfully read the file and print out the results
    @Test
    public void ReadFile() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("ReadTest.csv"));
        String expected = "File read";
        String actual = ReadFile.read(reader);
        Assert.assertEquals("example", expected, actual);
    }


}
