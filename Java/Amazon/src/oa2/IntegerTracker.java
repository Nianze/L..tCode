package oa2;

import java.util.*;

/**
 * Created by lnz on 1/5/17.
 */

public class IntegerTracker {
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;
    LinkedHashMap<Integer, Integer> countMap;
    int sum, total, maxCount;

    public IntegerTracker() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(10, Collections.reverseOrder());
        countMap = new LinkedHashMap<>();
        sum = 0;
        total = 0;
        maxCount = 0;
    }

    public void track(int num) {
        minHeap.offer(num);
        maxHeap.offer(num);
        sum += num;
        total++;
        countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        maxCount = Math.max(maxCount, countMap.get(num));
    }

    public int get_max() {
        return maxHeap.peek();
    }

    public int get_min() {
        return minHeap.peek();
    }

    public float get_mean() {
        return (float) sum / total;
    }

    public int get_mode() {
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (maxCount == entry.getValue()) {
                res = entry.getKey();
                break;
            }
        }
        return res;
    }

}
