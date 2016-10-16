// Created by Rym on 10/16/2016
import java.util.*;

public class MergeIntervals {
    // Definition for an interval.
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    // Time & space: O(n), O(1) - in place merge for linked list
    // Explanation: sort the intervals by start time, scan and merge
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval i1, Interval i2) {
                    return i1.start - i2.start;
                }
            });
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).end < intervals.get(i+1).start) {
                continue;
            }
            intervals.get(i).end = Math.max(intervals.get(i).end,
                                            intervals.get(i+1).end);
            intervals.remove(i+1);
            i--; // Do not forget about this !!!
        }
        return intervals;
    }
    
    // Time & space: O(n), O(n) - return a new arraylist
    // Explanation: sort the intervals by start time, scan and merge
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval i1, Interval i2) {
                    return i1.start - i2.start;
                }
            });
        List<Interval> rst = new ArrayList<Interval>();
        Interval last = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (last.end < curr.start) {
                rst.add(last);
                last = curr;
            } else {
                last.end = Math.max(last.end, curr.end);
            }
        }
        rst.add(last); // Do not forget about this !!!
        return rst;
    }    
}
