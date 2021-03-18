package Simple.Test;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;

public class RenameFileTest {
    @Test
    /*
    due to doing this part last min i never got chance to explore how i could keep renaming a file without it affecting
    the rest of the code, eg i had to keep changing the old path name in order for this to work
    however within this code i explored how i could rename a file, with keeping all the data

    orginally i did a much larger methord by storing the information in an array, deleting the file, making a new file
    with a new name and copying the array into the file. after seeing the amount of code that required i tried to find
    a much shorter methord.

   the test here shows that the expected outcome should return file renamed success meaning that the if statement
   asking if the file has been renamed was used, i also did a fail test to show how if the name of the file is not found
   the program doesnt crash but instead prints failed to rename file

     */

    public void RenameFile() throws Exception {

        Search_By_Title file = new Search_By_Title();
        BufferedReader reader = file.getReader();
        String expected = "file renamed success";
        String actual = Renamefile.renamefile("Testfile4", "Testfile3.csv");
        Assert.assertEquals("example", expected, actual);
    }
    @Test
    public void RenameFilefail() throws Exception {

        Search_By_Title file = new Search_By_Title();
        BufferedReader reader = file.getReader();
        String expected = "Failed to delete the file";
        String actual = Renamefile.renamefile("Testfile1", "Test.csv");
        Assert.assertEquals("example", expected, actual);
    }
}
