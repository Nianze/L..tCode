package oa2;
/**
 * input是一个arraylist，里面每一个element是一个pair，
 * studentid和他的一个score。
 * code就是要把这个list里面的所有学生的所有分数都读进去 
 * 然后计算每一个学生最高5个分数的平均值 
 * return 一个map key是id value是平均分
 */

import java.util.*;

class Result{
    int id;
    int value;
    public Result(int id, int value){
        this.id = id;
        this.value = value;
    }
}

public class HighFive {
	public static Map<Integer, Double> getHighFive(Result[] results) {
        Map<Integer, Double> map = new HashMap<>();
        Map<Integer, List<Integer>> scores = new HashMap<>();

        for (Result result : results) {
            int id = result.id;
            if (!scores.containsKey(id)) {
                scores.put(id, new ArrayList<>());
            }
            List<Integer> list = scores.get(id);
            list.add(result.value);
            scores.put(id, list);
        }

        HashMap<Integer, Double> ans = new HashMap<>();
        Queue<Integer> minHeap = new PriorityQueue<>(5);
        for (Integer id : scores.keySet()) {
            List<Integer> list = scores.get(id);
            for (Integer i : list) {
                if (minHeap.size() < 5) minHeap.offer(i);
                else {
                    if (minHeap.peek() < i) {
                        minHeap.poll();
                        minHeap.offer(i);
                    }
                }
            }
            int sum = 0;
            while (!minHeap.isEmpty()) {
                sum += minHeap.poll();
            }
            ans.put(id, (double) sum / 5);
        }
        return ans;
	}
}
