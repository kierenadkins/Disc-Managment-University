package Simple.Test;
import org.junit.Assert;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class SearchByTitleTest {
    /* the purpose of this test is to get the disc location from a function,
    this allows that later on any changes to the disc file will be made in all other functions
    this test shows that the disc file can be retrieved from the get reader class
     */
    /* in this test i wanted to search the file with a title and recive the full records
    the purpose of the test is to ensure that only the record with the title "example3"
    is printed for the user to see.
    in string expected i have wrote the entire line for example3
     */
    @Test
    public void searchTitleTest() throws Exception {

        Search_By_Title file = new Search_By_Title();
        BufferedReader reader = file.getReader();
        String expected = "example3, 2020, heavy, taylor, 200, 140s, null, null,Music";
        String actual = file.SearchByTitle("example3", reader); //passing the search word and the reader
        Assert.assertEquals("example", expected, actual);
    }
    @Test
    /*
    the function of this test was to ensure that if a random Title not found eithin the file
    is searched then an error should occur describing the title cannot be found
    this pervents the program from either crashing or displaying nothing.
    as a result the program tests if the string "not found" if printed
     */
    public void searchTitleTest2() throws Exception {

        Search_By_Title file = new Search_By_Title();
        BufferedReader reader = file.getReader();
        String expected = "not found";
        String actual = file.SearchByTitle("fail", reader);
        Assert.assertEquals("example", expected, actual);
    }

}






