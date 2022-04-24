package Cut;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CutStringTest {
@Test
    public void startEndSet(){
    var a = CutString.cutString(true, 0, 1,"123");
    assertEquals("1", a );
    a = CutString.cutString(true, 1, 2,"123");
    assertEquals("2", a );
    a = CutString.cutString(true, 2, 3,"123");
    assertEquals("3", a );

    a = CutString.cutString(false, 0, 1,"он приехал домой" );
    assertEquals("он", a );
    a = CutString.cutString(false, 1, 2,"он приехал домой");
    assertEquals("приехал", a );
    a = CutString.cutString(false, 2, 3,"он приехал домой");
    assertEquals("домой", a );

    a = CutString.cutString(false, 0, 2,"он приехал домой");
    assertEquals("он приехал", a );


}
@Test
    public void whenStartNotSetStartIs0() {
    var a = CutString.cutString(true, -1, 1,"123");
    assertEquals("1", a );
    a = CutString.cutString(true, -1, 2,"123");
    assertEquals("12", a );
    a = CutString.cutString(true, -2, 2,"123");
    assertEquals("12", a );



    a = CutString.cutString(false, -1, 1,"он приехал домой" );
    assertEquals("он", a );
    a = CutString.cutString(false, -1, 2,"он приехал домой");
    assertEquals("он приехал", a );
    a = CutString.cutString(false, -2, 2,"он приехал домой");
    assertEquals("он приехал", a );


}
    @Test
    public void whenEndNotSetEndIsLast() {
        var a = CutString.cutString(true, 0, -1,"123");
        assertEquals("123", a );
        a = CutString.cutString(true, 0, 3,"123");
        assertEquals("123", a );
        a = CutString.cutString(true, 0, 4,"123");
        assertEquals("123", a );
        a = CutString.cutString(true, 0, 5,"123");
        assertEquals("123", a );
        a = CutString.cutString(true, -1, -1,"123");
        assertEquals("123", a );

        a = CutString.cutString(false, 0, -1,"он приехал домой" );
        assertEquals("он приехал домой", a );
        a = CutString.cutString(false, 0, 3,"он приехал домой");
        assertEquals("он приехал домой", a );
        a = CutString.cutString(false, -2, 4,"он приехал домой");
        assertEquals("он приехал домой", a );
    }


}