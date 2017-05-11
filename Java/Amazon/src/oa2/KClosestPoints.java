package oa2;
import java.util.*;

class Point {
    double x;
    double y;
    public Point(double a, double b) {
        x = a;
        y = b;
    }
}

public class KClosestPoints {
	
	static public Point[] Solution(Point[] A, int k) {
		if (A == null) {
            return new Point[k];
        }
        Point origin = new Point(0, 0);
		PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(1, new Comparator<Point>() {
			@Override
			public int compare (Point a, Point b) {
				return (int) (distSquare(b, origin) - distSquare(a, origin));
			}
		});
		for (int i = 0; i < A.length; i++) {
            maxHeap.offer(A[i]);
            if (maxHeap.size() > k) maxHeap.poll();
		}
		Point[] ans = new Point[k];
		int index = maxHeap.size()-1;
		while (!maxHeap.isEmpty()) {
			ans[index--] = maxHeap.poll();
		}
		return ans;
	}
	
	private static double distSquare(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

}


