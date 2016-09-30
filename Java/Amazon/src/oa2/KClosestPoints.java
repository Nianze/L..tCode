package oa2;
import java.util.*;

public class KClosestPoints {
	class Point {
		double x;
		double y;
		public Point(double a, double b) {
			x = a;
			y = b;
		}
	}	
	
	public Point[] Solution(Point[] A, Point origin, int k) { 
		PriorityQueue<Point> heap = new PriorityQueue<Point>(k, new Comparator<Point>() {
			@Override
			public int compare (Point a, Point b) {
				return (int) (distSquare(a, origin) - distSquare(b, origin));
			}
		});
		
		for (int i = 0; i < A.length; i++) {
			heap.offer(A[i]);
			if (heap.size() > k) {
				heap.poll();
			} 				
		}
		
		Point[] ans = new Point[k];
		int index = 0;
		while (!heap.isEmpty()) {
			ans[index++] = heap.poll();
		}
		return ans;
	}
	
	private static double distSquare(Point a, Point b) {
		return (a.x - b.x)*(a.x - b.x) + (a.y - b.y) * (a.y - b.y); 
	}
}
