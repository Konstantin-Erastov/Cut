package Cut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CutParametersTest {
    CutParameters cutParameters;
    @BeforeEach
    public void setUp(){
    }
    @Test
    public void parseRange(){
        var cutParameters = new CutParameters(new String[]{"-c", "1-2"});
        assertEquals(1,cutParameters.getRangeStart());
        assertEquals(2,cutParameters.getRangeEnd());

        cutParameters = new CutParameters(new String[]{"-c","1-"});
        assertEquals(1,cutParameters.getRangeStart());
        assertEquals(-1,cutParameters.getRangeEnd());

        cutParameters = new CutParameters(new String[]{"-c","-2"});
        assertEquals(0,cutParameters.getRangeStart());
        assertEquals(2,cutParameters.getRangeEnd());

        assertThrows(IllegalArgumentException.class,()-> new CutParameters(new String[]{"-c","12"}));

    }

    @Test
    public void parseAll(){
        var cutParameters = new CutParameters(new String[]{"-c","1.txt","1-2"});
        assertEquals(cutParameters.getInputFileName(), "1.txt");
        assertEquals(cutParameters.getOutputFileName(), "");
        assertEquals(1,cutParameters.getRangeStart());
        assertEquals(2,cutParameters.getRangeEnd());
        assertTrue(cutParameters.getOffsetInChars());
        assertFalse(cutParameters.getOffsetInWords());

        cutParameters = new CutParameters(new String[]{"-w", "-o", "out.txt","1.txt","1-2"});
        assertEquals(cutParameters.getInputFileName(), "1.txt");
        assertEquals(cutParameters.getOutputFileName(), "out.txt");
        assertEquals(1,cutParameters.getRangeStart());
        assertEquals(2,cutParameters.getRangeEnd());
        assertFalse(cutParameters.getOffsetInChars());
        assertTrue(cutParameters.getOffsetInWords());

        cutParameters = new CutParameters(new String[]{"-w", "1-2"});
        assertEquals(cutParameters.getInputFileName(), "");
        assertEquals(cutParameters.getOutputFileName(), "");
        assertEquals(1,cutParameters.getRangeStart());
        assertEquals(2,cutParameters.getRangeEnd());
        assertFalse(cutParameters.getOffsetInChars());
        assertTrue(cutParameters.getOffsetInWords());
    }
    @Test
    public void parseOffset(){
        var cutParameters = new CutParameters(new String[]{"-c","1-2"});
        assertTrue(cutParameters.getOffsetInChars());
        assertFalse(cutParameters.getOffsetInWords());

        cutParameters = new CutParameters(new String[]{"-w","1-2"});
        assertFalse(cutParameters.getOffsetInChars());
        assertTrue(cutParameters.getOffsetInWords());

        assertThrows(IllegalArgumentException.class,()-> new CutParameters(new String[]{"1-2"}));
    }

}