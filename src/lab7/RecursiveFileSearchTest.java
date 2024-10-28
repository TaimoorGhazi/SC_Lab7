package lab7;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;

public class RecursiveFileSearchTest {
    private RecursiveFileSearch fileSearchInstance;

    @Before
    public void setup() {
        fileSearchInstance = new RecursiveFileSearch();
    }

    @Test
    public void testFileExists() {
        String directoryPath = "C:\\Users";
        String fileName = "exampleFile.pdf";

        fileSearchInstance.searchFile(new File(directoryPath), fileName);

        assertTrue("File should be found", fileSearchInstance.isFileFound());
        assertNotNull("File path should not be null", fileSearchInstance.getFilePath());
        assertTrue("File path should end with the target filename",
                fileSearchInstance.getFilePath().endsWith(fileName));
    }

    @Test
    public void testFileDoesNotExist() {
        String directoryPath = "src/test/resources";
        String fileName = "nonExistingFile.txt";

        fileSearchInstance.searchFile(new File(directoryPath), fileName);

        assertFalse("File should not be found", fileSearchInstance.isFileFound());
        assertNull("File path should be null when file is not found", fileSearchInstance.getFilePath());
    }
}
