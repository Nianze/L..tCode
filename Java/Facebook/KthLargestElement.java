// Created by Rym on 10/18/2016
public class KthLargestElement {
    // O(NlgK) running time + O(K) memory
    public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int val : nums) {
        pq.offer(val);
        if(pq.size() > k) {
            pq.poll();
        }
    }
    return pq.peek();
    }

    // O(N) best case, O(N^2) worst case running time, O(1) memory
    // quick select
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k - 1, 0, nums.length - 1);
    }
    
    private int quickSelect(int[] arr, int k, int left, int right){
        int pivot = arr[(left + right) / 2];
        int orgL = left, orgR = right;
        while(left <= right){
            // 从右向左找到第一个小于枢纽值的数
            while(arr[left] > pivot){
                left ++;
            }
            // 从左向右找到第一个大于枢纽值的数
            while(arr[right] < pivot){
                right --;
            }
            // 将两个数互换
            if(left <= right){
                swap(arr, left, right);
                left ++;
                right --;
            }
        }
        // 最后退出的情况应该是右指针在左指针左边一格
        // 这时如果右指针还大于等于k，说明kth在左半边
        if(orgL < right && k <= right) return quickSelect(arr, k, orgL, right);
        // 这时如果左指针还小于等于k，说明kth在右半边
        if(left < orgR && k >= left) return quickSelect(arr, k, left, orgR);
        return arr[k];
    
    }
    
    private void swap(int[] arr, int idx1, int idx2){
        int tmp = arr[idx1] + arr[idx2];
        arr[idx1] = tmp - arr[idx1];
        arr[idx2] = tmp - arr[idx2];
    
    }    
}
