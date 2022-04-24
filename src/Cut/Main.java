package Cut;

import java.io.*;

public class Main {
 public static void main(String[] args) throws IOException {
     var p=new CutParameters(args);
     var cutter = new Cutter(p);
        cutter.start();

 }


}
