// Created by Rym on 2016.12.27

public class Solution {
    // O(log(m+n))
    // use getKth, k is about half of (m+n)
    // every time getKth reduce the scale of k to its half
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) return findKth(nums1, 0, nums2, 0, len/2 + 1);
        return (findKth(nums1, 0, nums2, 0, len/2) + findKth(nums1, 0, nums2, 0, len/2 + 1)) / 2.0;
    }
    private int findKth(int[] n1, int start1, int[] n2, int start2, int k) {
        if (start1 >= n1.length) return n2[start2 + k - 1];
        if (start2 >= n2.length) return n1[start1 + k - 1];
        if (k == 1) return Math.min(n1[start1], n2[start2]);
        int mid1 = (start1 + k/2 - 1) < n1.length ? n1[start1 + k/2 - 1] : Integer.MAX_VALUE;
        int mid2 = (start2 + k/2 - 1) < n2.length ? n2[start2 + k/2 - 1] : Integer.MAX_VALUE;
        if (mid1 < mid2) return findKth(n1, start1 + k/2, n2, start2, k - k/2);
        else return findKth(n1, start1, n2, start2 + k/2, k - k/2);
    }

    // O(log(min(m,n)))
    
}
