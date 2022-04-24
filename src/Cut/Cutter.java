package Cut;

import java.io.*;

public class Cutter {
    private final InputStream in;
    private final CutParameters parameters;
    private final PrintStream out;

    public Cutter(CutParameters parameters) throws FileNotFoundException {
        if (parameters.getInputFileName().length()!=0){
            in = new FileInputStream(parameters.getInputFileName());
        }
        else {
            in=System.in;
        }
        if (parameters.getOutputFileName().length()!=0){
            out = new PrintStream(parameters.getOutputFileName());
        }
        else {
            out = System.out;
        }
        this.parameters = parameters;

    }

    public void start() throws IOException {

        var reader = new BufferedReader(new InputStreamReader(in));
        var line = reader.readLine();
        while(line!=null) {
            var cuttedLine = processLine(line);
            out.println(cuttedLine);
            line = reader.readLine();
        }
        in.close();
        out.flush();
        out.close();
    }

    private String processLine(String line) {
        return CutString.cutString(parameters.getOffsetInChars(), parameters.getRangeStart(), parameters.getRangeEnd(), line);
    }
}
