package oa2;

/**
 * Given a list of integers and a window size, 
 * return a new list of integers where each integer is the sum of all integers 
 * in the kth window of the input list. The kth window of the input list is the integers from 
 * index k to index  k + window size - 1(inclusive).
 * Example: 
 * [4,2,73,11,-5], window size 2 --> return [6,75,84,6]
 * [4,2,73,11,-5], window size 3 --> return [79,86,79]
 */
import java.util.*;

public class WindowSum {
	public List<Integer> GetSum(List<Integer> A, int k) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if (A == null || A.size() == 0) {
			return null;
		}		
		int len = A.size();
		for (int i = 0; i + k - 1 < len; i++) {
			int sum = 0;
			for (int j = 0; j < k; j++) {
				sum += A.get(i + j);
			}
			ans.add(sum);
		}
		return ans;
	}
	
	public int[] sumOfWindow(int[] A, int k) {
		if (A == null || A.length == 0) {
			return null;
		}
		int[] ans = new int[A.length - k + 1];
		for(int i = 0; i < k; i++) {
			ans[0] += A[i];
		}
		for (int i = 1; i < ans.length; i++) {
			ans[i] = ans[i - 1] - A[i] + A[i + k - 1];
		}
		return ans;
	}
}
