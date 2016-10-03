import java.util.*;

/**
 * Airbnb
 */
public class SplitByPages {
    public static void splitByPages(List<String> input) {
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
            if (sum == num) { // End of a page
                hostIDs.clear();
                sum = 0;
                ans.add("");
                inputIterator = input.iterator();
            }
            if (!inputIterator.hasNext()) {
                hostIDs.clear();
                inputIterator = input.iterator();
            }
        }
        return ans.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] strs = new String[]{
                "1,28,300.1,SanFrancisco",
                "4,5,209.1,SanFrancisco",
                "20,7,208.1,SanFrancisco",
                "23,8,207.1,SanFrancisco",
                "16,10,206.1,Oakland",
                "1,16,205.1,SanFrancisco",
                "6,29,204.1,SanFrancisco",
                "7,20,203.1,SanFrancisco",
                "8,21,202.1,SanFrancisco",
                "2,18,201.1,SanFrancisco",
                "2,30,200.1,SanFrancisco",
                "15,27,109.1,Oakland",
                "10,13,108.1,Oakland",
                "11,26,107.1,Oakland",
                "12,9,106.1,Oakland",
                "13,1,105.1,Oakland",
                "22,17,104.1,Oakland",
                "1,2,103.1,Oakland",
                "28,24,102.1,Oakland",
                "18,14,11.1,SanJose",
                "6,25,10.1,Oakland",
                "19,15,9.1,SanJose",
                "3,19,8.1,SanJose",
                "3,11,7.1,Oakland",
                "27,12,6.1,Oakland",
                "1,3,5.1,Oakland",
                "25,4,4.1,SanJose",
                "5,6,3.1,SanJose",
                "29,22,2.1,SanJose",
                "30,23,1.1,SanJose"
        };
        List<String> input = new ArrayList<>(Arrays.asList(strs));
        splitByPages(input);
    }
}
