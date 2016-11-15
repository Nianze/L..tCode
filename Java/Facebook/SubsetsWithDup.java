// Created by Rym on 10/20/2016
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> builder, int[] nums, int start) {
        list.add(new ArrayList<Integer>(builder));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;
            builder.add(nums[i]);
            backtrack(list, builder, nums, i+1);
            builder.remove(builder.size() - 1);
        }
    }
}
