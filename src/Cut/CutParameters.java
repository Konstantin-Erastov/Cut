package Cut;

public class CutParameters {

    private final String inputFileName;
    private final String outputFileName;
    private final Boolean offsetInWords;
    public Boolean getOffsetInChars(){
        return !offsetInWords;
  }

    public int getRangeStart() {
        return rangeStart;
    }

    private int rangeStart = -1;
    private int rangeEnd = -1;
    public CutParameters(String[] args){

        if (args.length < 2) {
            throw new IllegalArgumentException("Missing required argument: range");
        }
        var i = 0;
        offsetInWords = parseOffsetInWords(args[i]);
        i++;
        var arg = args[i];
        if (arg.charAt(0)=='-' && arg.charAt(1)=='o'){
            i++;
         outputFileName = args[i];
         i++;
        } else {
            outputFileName = "";
        }
      if (args.length-i > 1) {
          inputFileName = args[i];
          i++;
      } else {
          inputFileName = "";
      }

        parseRange(args[i]);

    }

    private boolean parseOffsetInWords(String arg) {
        if (arg.charAt(0)=='-' && arg.charAt(1)=='c'){
            return false;
        }
        if (arg.charAt(0)=='-' && arg.charAt(1)=='w'){
            return true;
        }
            throw new IllegalArgumentException("Missing required argument: -c/-w");
    }

    private void parseRange(String range) {
        if (!range.contains("-")) {
            throw new IllegalArgumentException("Missing \"-\" in argument range");
        }
        if (range.trim().length() == 1) {
            throw new IllegalArgumentException("Missing number in argument range");
        }
        var parts = range.split("-");

        // -2
        if (range.charAt(0)=='-') {
            rangeStart= 0;
            rangeEnd= Integer.parseInt(parts[1]);
            return;
        }

        // 2-
        if (range.endsWith("-")) {
            rangeStart = Integer.parseInt(parts[0]);
            rangeEnd = -1;
            return;
        }

        // 1-2
        if (parts.length == 2) {
            rangeStart = Integer.parseInt(parts[0]);
            rangeEnd = Integer.parseInt(parts[1]);
        }

    }

    public int getRangeEnd() {
        return rangeEnd;
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public boolean getOffsetInWords() {
        return offsetInWords;
    }

    public String getOutputFileName() {
        return outputFileName;
    }
}
