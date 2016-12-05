// Created by Rym on 10/29/2016
public class HIndexII {
    // use binary search to find the minimum index such that:
    // citations[index] >= len(citations) - index
    // return: len(citations) - index
    // Complexity: Time O(log n), Space O(1)
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int len = citations.length;
        int start = 0, end = len - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (citations[mid] == len - mid) {
                return len - mid;
            } else if (citations[mid] > len - mid) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (citations[start] >= len - start) return len - start;
        if (citations[end] >= len - end) return len - end;
        return 0;
    }
}

// 2 3 3 3 -> return 3

/**
 * \
 *   \_ _ /  -> f(index) = citations[index]
 * /    \
 *        \  -> f(index) = len - index
 */
