import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by WengTianhui on 9/28/16.
 */
public class Fitbit {
    public static List<String> runJob(String[] input) {
        List<String> results = new ArrayList<>();

        String standard = input[0];
        if (!(standard.equals("Largest") || standard.equals("Latest"))) return results;

        int number = 0;
        try {
            number = Integer.parseInt(input[1]);
        } catch (NumberFormatException e) {
            return results;
        }

        List<String[]> files = new ArrayList<>();
        for (int i = 2; i < input.length; i++) {
            try {
                Long.parseLong(input[i].split(",")[1]);
                Long.parseLong(input[i].split(",")[2]);
            } catch (NumberFormatException e) {
                continue;
            }
            files.add(input[i].split(","));
        }
        if (files.size() < number) return results;

        // Size, Time, FileName
        Comparator<String[]> comparatorForLargest = new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                long time1 = Long.parseLong(o1[1]);
                long time2 = Long.parseLong(o2[1]);
                long size1 = Long.parseLong(o1[2]);
                long size2 = Long.parseLong(o2[2]);
                if (size1 != size2) return (int) ((size2 - size1) / Math.abs(size2 - size1));
                else if (time1 != time2) return (int) ((time2 - time1) / Math.abs(time2 - time1));
                else return o1[0].compareTo(o2[0]);
            }
        };

        // Time, Size, FileName
        Comparator<String[]> comparatorForLatest = new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                long time1 = Long.parseLong(o1[1]);
                long time2 = Long.parseLong(o2[1]);
                long size1 = Long.parseLong(o1[2]);
                long size2 = Long.parseLong(o2[2]);
                if (time1 != time2) return (int) ((time2 - time1) / Math.abs(time2 - time1));
                else if (size1 != size2) return (int) ((size2 - size1) / Math.abs(size2 - size1));
                else return o1[0].compareTo(o2[0]);
            }
        };

        if (standard.equals("Largest")) Collections.sort(files, comparatorForLargest);
        if (standard.equals("Latest")) Collections.sort(files, comparatorForLatest);

        for (int i = 0; i < number && i < files.size(); i++)
            if (!results.contains(files.get(i)[0]))     // Avoid duplicate names.
                results.add(files.get(i)[0]);
        return results;
    }

    public static void main(String[] args) {
        String[] input = {"Latest", "8", "f1,10,50", "f2,20,90", "f3,10,100", "f4,30,40", "f3,10,10","f5,5,100", "f6,30,5", "f7,20,80", "f8,10,20"};
        // Largest: f3,f5,f2,f7,f1,f4,f8,f6
        // Latest: f4,f6,f2,f7,f3,f1,f8,f5
        List<String> result = runJob(input);
        System.out.println(result);
    }
}
