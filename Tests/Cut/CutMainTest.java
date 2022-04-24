package Cut;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class CutMainTest {


    private void assertFilesEqual(String expectedName, String actualName) throws IOException {

        var expected = new String ( Files.readAllBytes( Paths.get(expectedName) ) );
        var actual = new String ( Files.readAllBytes( Paths.get(actualName) ) );
        assertEquals(expected, actual);
    }
@Test
    public void test() throws IOException {
    var p = new CutParameters(new String[]{"-w", "-o", "Tests/files/1_expected.txt", "Tests/files/1_in.txt", "1-4"});
    var c = new Cutter(p);
    c.start();
    assertFilesEqual("Tests/files/1_expected.txt","Tests/files/1_expected.txt");
}
}