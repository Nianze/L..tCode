public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++) {
            int leftover = target - nums[i];
            if (map.containsKey(leftover)) {
                return new int[]{map.get(leftover), i};
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /* LeetCode Two Sum II
     * @param numbers : An sorted ascending array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */    
    public int[] twoSum_II(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        //Arrays.sort(nums);
        while(start < end) {
            int sum = nums[start] + nums[end];
            if ( sum == target) {
                return new int[]{start + 1, end + 1};
            }
            if ( sum  < target) {
                start++;
            }
            if ( sum > target) {
                 end --;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /* LintCode Two Sum II
     * @param numbers : An array of Integer
     * @param target : target < numbers[index1] + numbers[index2]
     * @return : number of pairs
     */    
    public int twoSum_II(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int ans = 0;
        Arrays.sort(nums);
        while(start < end) {
            int sum = nums[start] + nums[end];
            if ( sum > target) {
                ans = ans + end - start;
                end --;
            } else {
                start++;
            }
        }
        return ans;
    }
}
