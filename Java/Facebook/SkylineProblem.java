// Created by Rym on 11/06/2016
public class SkylineProblem {
    // Method 1: O(nlog(n)), divide and conquer like the merge sort.
    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings.length == 0) return new LinkedList<int[]>();
        return divide(buildings, 0, buildings.length - 1);
    }
    private LinkedList<int[]> divide(int[][] buildings, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            return merge(divide(buildings, start, mid),
                         divide(buildings, mid + 1, end));
        }
        // start == end
        LinkedList<int[]> ans = new LinkedList<>();
        ans.add(new int[] {buildings[start][0], buildings[start][2]});
        ans.add(new int[] {buildings[start][1], 0});
        return ans;
    }
    // Due to the use of l.getFirst(), must set argument and return type as LinkedList<> rather than List<>
    private LinkedList<int[]> merge(LinkedList<int[]> l1, LinkedList<int[]> l2) {
        LinkedList<int[]> ans = new LinkedList<>();
        int h1 = 0, h2 = 0;
        while (!l1.isEmpty() && !l2.isEmpty()) {
            int x = 0, h = 0;
            if (l1.getFirst()[0] < l2.getFirst()[0]) {
                x = l1.getFirst()[0];
                h1 = l1.removeFirst()[1];
            } else if (l1.getFirst()[0] > l2.getFirst()[0]) {
                x = l2.getFirst()[0];
                h2 = l2.removeFirst()[1];
            } else {
                x = l1.getFirst()[0];
                h1 = l1.removeFirst()[1];
                h2 = l2.removeFirst()[1];
            }
            h = Math.max(h1, h2);
            if (ans.isEmpty() || h != ans.getLast()[1]) {
                ans.add(new int[]{x, h});
            }
        }
        ans.addAll(l1);
        ans.addAll(l2);
        return ans;
    }

    // Method 2: O(n^2), sort and 1pass using max heap.(heap.remove time is O(n)).
    // ref: https://discuss.leetcode.com/topic/28482/once-for-all-explanation-with-clean-java-code-o-n-2-time-o-n-space/2
}
