class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutes = new ArrayList<List<Integer>>();
        if (nums <= 0) {
            return permutes;
        }
        List<Integer> layer0 = new ArrayList<Integer>();
        layer0.add(nums[0]);
        permutes.add(layer0);
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> newLayer = new ArrayList<List<Integer>>();
            for (int j = 0; j <= i; j++) {
                for (List<Integer> permute : permutes) {
                    ArrayList<Integer> newPermute = new ArrayList<Integer>(permute);
                    newPermute.add(j, nums[i]);
                    newLayer.add(newPermute);
                }
            }
            permutes = newLayer;
        }
        return permutes;
    }

    // Recursive - suitable for non-duplicated nums
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (nums == null) {
            return ans;
        }

        if (nums.length == 0) {
            ans.add(new ArrayList<Integer>());
            return ans;
        }

        ArrayList<Integer> builder = new ArrayList<Integer>();
        helper(ans, builder, nums);
        return ans;
    }

    private void helper(ArrayList<List<Integer>> ans, ArrayList<Integer> builder, int nums[]) {
        if (builder.size() == nums.length) {
            ans.add(new ArrayList<Integer>(builder));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!builder.contains(nums[i])) {
                builder.add(nums[i]);
                helper(ans, builder, nums);
                builder.remove(builder.size() - 1);
            }
        }
    }
}
