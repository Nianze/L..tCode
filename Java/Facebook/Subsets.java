// Created by Rym on 10/18/2016
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> builder, int[] nums, int start) {
        list.add(new ArrayList<Integer>(builder));
        for (int i = start; i < nums.length; i++) {
            builder.add(nums[i]);
            backtrack(list, builder, nums, i +1);
            builder.remove(builder.size() - 1);
        }
    }
}
