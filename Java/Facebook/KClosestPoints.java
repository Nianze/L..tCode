// Created by Rym on 10/26/2016
public class KClosestPoints {
    class Point {
        double x;
        double y;
        public Point(double a, double b) {
            x = a;
            y = b;
        }
    }
    // max heap    
    public Point[] kClosestPoints(Point[] A, Point origin, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(k, new Comparator<Point>() {
                @Override
                public int compare (Point a, Point b) {
                    return (int) (distSquare(b, origin) - distSquare(a, origin));
                }
            });
        for (int i = 0; i < A.length; i++) {
            if (maxHeap.size() < k) {
                maxHeap.offer(A[i]);
            } else if (distSquare(maxHeap.peek(), origin) > distSquare(A[i], origin)){
                maxHeap.poll();
                maxHeap.offer(A[i]);
            }
        }
        Point[] ans = new Point[k];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            ans[index++] = maxHeap.poll();
        }
        return ans;
    }
    private static double distSquare(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y); 
    }

    
    // Quick select
    
}
