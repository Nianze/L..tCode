// Created by Rym on 11/08/2016

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new ArrayList<>();        
        int i = 0, n = intervals.size();
        while (i < n && intervals.get(i).end < newInterval.start) {
            ans.add(intervals.get(i++));
        }
        if (i < n) newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
        while (i < n && intervals.get(i).start <= newInterval.end) {
            newInterval.end = Math.max(newInterval.end, intervals.get(i++).end);
        }
        ans.add(newInterval);
        while(i < n) {ans.add(intervals.get(i++));}
        return ans;
    }
}
