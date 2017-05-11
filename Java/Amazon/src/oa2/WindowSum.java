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
public class WindowSum {
	
	public static int[] sumOfWindow(int[] A, int k) {
        if (A == null || A.length == 0) {
            return null;
        }
        int len = k <= A.length ? A.length - k + 1 : 1;
        int[] ans = new int[len];
        for (int i = 0; i < Math.min(k, A.length); i++) {
            ans[0] += A[i];
        }
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i - 1] - A[i-1] + A[i + k - 1];
        }
        return ans;
    }

}
