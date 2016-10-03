import java.util.*;

/**
 * Airbnb
 */
public class SplitByPages {
    public static String[] splitByPages(int num, String[] results) {
        if (results == null || results.length == 0) {
            return new String[0];
        }

        ArrayList<String> input = new ArrayList<String>();
        for (int i = 0; i < results.length; i++) {
            input.add(results[i]);
        }

        Iterator<String> inputIterator = input.iterator();
        Set<String> hostIDs = new HashSet<>();
        ArrayList<String> ans = new ArrayList<String>();
        int sum = 0;

        while (inputIterator.hasNext()) {
            String currentLine = inputIterator.next();
            String hostID = currentLine.split(",")[0];
            if (hostIDs.add(hostID)) {
                //System.out.println(currentLine);
                ans.add(currentLine);
                sum++;
                inputIterator.remove();
            }

            if (!inputIterator.hasNext()) {
                hostIDs.clear();
                inputIterator = input.iterator();
                while (sum < num && inputIterator.hasNext()) {
                    currentLine = inputIterator.next();
                    ans.add(currentLine);
                    sum++;
                    inputIterator.remove();
                }
                if (inputIterator.hasNext())
                    ans.add("");
                sum = 0;
            }

            if (sum == num && inputIterator.hasNext()) { // End of a page
                hostIDs.clear();
                sum = 0;
                ans.add("");
                inputIterator = input.iterator();
            }
        }
        return ans.toArray(new String[0]);

    }

    public static void main(String[] args) {
        String[] input = new String[]{
                "1,28,300.6,San Francisco",
                "4,5,209.1,San Francisco",
                "20,7,203.4,Oakland",
                "6,8,202.9,San Francisco",
                "6,10,199.8,San Francisco",
                "1,16,190.5,San Francisco",
                "6,29,185.3,San Francisco",
                "7,20,180.0,Oakland",
                "6,21,162.2,San Francisco",
                "2,18,161.7,San Jose",
                "2,30,149.8,San Josev",
                "3,76,146.7,San Francisco",
                "2,14,141.8,San Jose"
        };
        String[] result = splitByPages(5, input);
        System.out.println(result);
    }
}
