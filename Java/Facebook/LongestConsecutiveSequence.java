// Created by Rym on 11/08/2016
public class LongestConsecutiveSequence {
    // random order, hashmap !
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int n : nums) {
            if (map.containsKey(n)) continue;
            int left = 0, right = 0, temp = 1;
            if (map.containsKey(n - 1)) left = map.get(n - 1);
            if (map.containsKey(n + 1)) right = map.get(n + 1);
            temp = temp + left + right;
            ans = Math.max(temp, ans);
            map.put(n, temp);
            if (left != 0) map.put(n - left, temp);
            if (right != 0) map.put(n + right, temp);
        }
        return ans;
    }
}
