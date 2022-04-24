package Cut;

public class CutString {

    private final boolean offsetInChars;
    private final int start;
    private final int end;

    public CutString(boolean offsetInChars, int start, int end) {
        this.offsetInChars = offsetInChars;
        this.start = start;
        this.end = end;
    }

    public String cut(String s) {
        return cutString(offsetInChars, start, end, s);
    }
    public static String cutString(boolean offsetInChars, int start, int end, String s){
        if (start < 0) {
            start = 0;
        }

        if (offsetInChars) {
            if (end == -1 || end >= s.length()) {
                end = s.length();
            }
            return s.substring(start, end);
        }
        var words = s.split(" ");
        if (end == -1 || end >= words.length) {
            end = words.length;
        }
        StringBuilder r = new StringBuilder();
        for (int i = start; i < end; i++) {
            r.append(words[i]).append(" ");
        }
        if (r.length() > 1){
            r = new StringBuilder(r.substring(0, r.length() - 1));
        }
        return r.toString();
    }
}
