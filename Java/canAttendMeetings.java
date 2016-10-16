/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        try {
            Arrays.sort(intervals, new Comparator<Interval>() {
                    @Override
                    public int compare(Interval i1, Interval i2) {
                        if (i1.end <= i2.start) {
                            return -1;
                        } else if (i1.start >= i2.end) {
                            return 1;
                        }
                        new RuntimeException();
                    }
                });
        } catch (Exception e) {
            return false;
        }
        return true;        
    }
}
