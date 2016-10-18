//1. How to optimize the algorithm if given array is sorted ?
//2. Which algo is better if nums1's size is smaller ?
//3. What if elements of nums2 are stored on disk and the memory is
//  limited such that you cannot load all at once ?

public class IntersectionOfTwoArraysII {
    // Hashmap, for no dup case, use HashSet
    // O(m+n), O(m)
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> buffer = new ArrayList<Integer>();
        Map<Integer, Integer> map = HashMap<Integer, Integer>();        
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                map.put(num, map.get(num) - 1);
                buffer.add(num);
            }
        }
        int[] ans = new int[buffer.size()];
        for (int i = 0; i < buffer.size(); i++) {
            ans[i] = buffer.get(i);
        }
        return ans;
    }

    // if array is sorted, use two pointer method
    // Time: O(m+n) for sorted array, O(klog(k)) for unsorted, k=max(m,n)
    // space O(common(m,n))
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> buffer = new ArrayList<Integer>();
        int i1 = 0, i2 = 0;
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] > nums2[i2]) {
                i2++;
            } else if (nums1[i1] < nums2[i2]) {
                i1++;
            } else {
                buffer.add(nums1[i1]);
                i1++;
                i2++;
            }
        }
        int[] ans = new int[buffer.size()];
        for (int i = 0; i < buffer.size(); i++) {
            ans[i] = buffer.get(i);
        }
        return ans;
    }
    
    // for small nums1: sort nums1 and use binary search. O(n*log(m))
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        boolean[] check = new boolean[nums1.length];
        List<Integer> buffer = new ArrayList<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (binarySearch(nums1, nums2[i], check)) {
                buffer.add(nums2[i]);
            }
        }
        int[] ans = new int[buffer.size()];
        for (int i = 0; i < buffer.size(); i++) {
            ans[i] = buffer.get(i);
        }
        return ans;
    }
    private static boolean binarySearch(int[] nums,int target, boolean[] check) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                if (!check[mid]) {
                    check[mid] = true;
                    return true;
                } else {
                    return false;
                }
            }
        }
        if (nums[start] == target && !check[start]) {
            check[start] = true;
            return true;
        }
        if (nums[end] == target && !check[end]) {
            check[end] = true;
            return true;
        }        
        return false;
    }

    
    // - For large nums2, use hashmap to save nums1, read chunks of nums2
    // - If both are large, external sort the two array first, then read chunks of
    // data from both arraies and record intersection. 
}
