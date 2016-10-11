public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // k largest's index = nums[n-k] in sorted array
        int target = nums.length - k;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            final int pivot = partition(nums, lo, hi);
            if (pivot < target) {
                lo = pivot + 1;
            } else if (pivot > target){
                hi = pivot - 1;
            } else {
                break;
            }
        }
        return nums[target];
    }

    private int partition(int[] a, int start, int end) {
        int pivot = start;
        while(true) {
            while(start < end && a[start] <= a[pivot]) {
                start++;
            }
            while(start < end && a[end] >= a[pivot]) {
                end--;
            }
            if (start >= end){
                break;
            }
            swap(a, start, end);
        }
        swap(a, pivot, end);
        return end;
    }

    private void swap(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
