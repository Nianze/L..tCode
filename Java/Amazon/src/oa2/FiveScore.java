package oa2;
/**
 * input是一个arraylist，里面每一个element是一个pair，
 * studentid和他的一个score。
 * code就是要把这个list里面的所有学生的所有分数都读进去 
 * 然后计算每一个学生最高5个分数的平均值 
 * return 一个map key是id value是平均分
 */

import java.util.*;

public class FiveScore {
	class Score {
		int id;
		ArrayList<Integer> scores;
		Score(int x) {
			id = x;			
		}
	}
	
	public Map<Integer, Float> avgFiveScore(ArrayList<Score> list) {
		HashMap<Integer, Float> map = new HashMap<Integer, Float>();
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(5);
		for (Score sc : list) {
			ArrayList<Integer> scores = sc.scores;
			for (Integer i : scores) {
				if (heap.size() < 5) {
					heap.offer(i);
				} else {
					if (heap.peek() < i) {
						heap.poll();
						heap.offer(i);
					}
				}
			}
			int sum = 0;
			while (!heap.isEmpty()) {
				sum += heap.poll();
			}						
			map.put(sc.id, (float) sum / 5);
		}
		return map;
	}
}
