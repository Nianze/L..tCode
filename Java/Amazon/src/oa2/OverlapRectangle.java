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
	
	public static boolean check(Node topLeftA, Node topLeftB, Node bottomRightA, Node bottomRightB) {
		// one is above the other
		if (bottomRightA.y <= topLeftB.y || bottomRightB.y <= topLeftA.y) {
			return false;
		}
		// one is beside the other
		if (bottomRightA.x <= topLeftB.x || bottomRightB.x <= topLeftA.x) {
			return false;
		}
		return true;
	}
}
