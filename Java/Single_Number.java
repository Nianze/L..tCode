public class Solution {
    // Solution One: use XOR -> n1 XOR n2 XOR n2 XOR n1 XOR n3 = n3
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int n : nums) {
            result ^= n;
        }
        return result;
    }

    // solution two: using hash map to keep track of the freq
    // suitable for the case where there are more single integers
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int result = 0;
        for (int n : map.keySet()) {
            int freq = map.get(n);
            if (freq == 1) {
                result = n;
            }
        }
        return result;
    }
}
