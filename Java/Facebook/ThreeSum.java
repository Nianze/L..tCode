// Created by Rym on 10/18/2016
public class ThreeSum {
    // Sort array firstly
    // For each first element, use 2 pointer method in 2sum to find match
    // O(n^2), O(1)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1, target = 0 - nums[i];
            while (start < end) {
                if (nums[start] + nums[end] == target) {
                    ans.add(Arrays.asList(nums[i], nums[start],nums[end]));
                    while (start < end && nums[start] == nums[start+1]) {
                        start++;
                    }
                    while (start < end && nums[end] == nums[end-1]) {
                        end--;
                    }
                    start++;
                    end--;
                } else if (nums[start] + nums[end] < target) {
                    start++;
                } else {
                    end--;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i+1]) {i++;}
        }
        return ans;        
    }
}
