import java.util.ArrayList;
import java.util.List;

/**
 * Airbnb
 */
public class CSV_Parser {
    // Concatenate strings using a given delimiter
    public static String concatenateStrings(List<String> result, String delimiter) {
        if (result==null || result.size()==0)
            return "";

        StringBuffer string = new StringBuffer();
        for (int i=0; i<result.size()-1; i++) {
            string.append(result.get(i));
            string.append(delimiter);
        }
        string.append(result.get(result.size()-1));
        return string.toString();
    }

    // Parse file to CSV form.
    public static String parseCSV(String input) {
        if (input==null || input.length()==0) return "";

        List<String> result = new ArrayList<>();
        StringBuffer current = new StringBuffer();
        boolean inQuotes = false;

        for (int i=0; i<input.length(); i++) {
            char ch = input.charAt(i);
            if (!inQuotes) {
                if (ch == '"') inQuotes = true;
                else
                    if (ch == ',') {
                        // Finished one part of string, put in one block.
                        result.add(current.toString());
                        current.setLength(0);
                    }
                    else current.append(ch);
            }
            else
            {
                // In a pair of quotes.
                if (ch == '"') {
                    if (i==input.length()-1) {
                        result.add(current.toString());
                        return concatenateStrings(result, "|");
                    }
                    if (input.charAt(i+1) == '"') {
                        current.append(ch);
                        i++;
                    }
                    else {
                        // Jumped out of the quotes
                        result.add(current.toString());
                        current.setLength(0);
                        inQuotes = false;
                        i++; // "CA", -> jump over the comma followed by the double quote
                    }
                }
                else current.append(ch);
            }
        }
        if (current.length() > 0)
            result.add(current.toString());
        return concatenateStrings(result, "|");
    }

    public static void main(String[] args) {
        String input1 = "John,Smith,john.smith@gmail.com,Los Angeles,1";
        System.out.println(parseCSV(input1));

        String input2 = "Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0";
        System.out.println(parseCSV(input2));

        String input3 = "\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1";
        System.out.println(parseCSV(input3));

        String input4 = "\"\"\"Alexandra Alex\"\"\"";
        System.out.println(parseCSV(input4));
    }
}
