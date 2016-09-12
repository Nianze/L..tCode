public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (numbers == null || numbers.length == 0) {
            return ans;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue; // skip dup
            }
            int left = i + 1, right = numbers.length - 1;
            while(left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];
                if (sum == 0) {
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(numbers[left]);
                    tmp.add(numbers[i]);
                    tmp.add(numbers[right]);
                    ans.add(tmp);
                    left++;
                    right--;
                    while (left < right && numbers[left] == numbers[left - 1]) {
                        left++;
                    }
                    while (right > left && numbers[right] == numbers[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                }
            }
        }
        
        return ans;
    }
}
