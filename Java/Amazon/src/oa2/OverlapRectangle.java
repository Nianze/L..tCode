package oa2;

public class OverlapRectangle {
	class Node {
		double x;
		double y;
		public Node(double a, double b) {
			x = a;
			y = b;
		}
	}

	public static boolean isOverLap(Node topLeftA, Node topLeftB, Node bottomRightA, Node bottomRightB) {
		// one is above the other
		if (bottomRightA.y >= topLeftB.y || bottomRightB.y >= topLeftA.y) {
			return false;
		}
		// one is beside the other
		if (bottomRightA.x <= topLeftB.x || bottomRightB.x <= topLeftA.x) {
			return false;
		}
		return true;
	}

    /*
    int overlapRight = Math.min(Math.max(a, c), Math.max(e, g));
    int overlapLeft = Math.max(Math.min(a, c), Math.min(e, g));
    int overlapTop = Math.min(Math.max(b, d), Math.max(f, h));
    int overlapBottom = Math.max(Math.min(b, d), Math.min(f, h));

    return overlapRight > overlapLeft && overlapTop > overlapBottom;
    */

}
