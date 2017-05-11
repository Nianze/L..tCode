package oa2;

public class Solution {
    public static void main(String[] args) {
        // k closest points
        /*
        Point[] points = {new Point(4.5, 6.0), new Point(4, 7), new Point(4, 4), new Point(2, 5), new Point(1, 1)};
		Point[] points2 = {new Point(10000, 1), new Point(10000, 4), new Point(10000, 3), new Point(10000, 2), new Point(10000, 5)};
        Point[] points3 = {new Point(3, 3), new Point(2, 2), new Point(1, 1)};
        Point[] result = KClosestPoints.Solution(points, 2);
		Point[] result2 = KClosestPoints.Solution(points2, 2);
        Point[] result3 = KClosestPoints.Solution(points3, 5);
		for (int i = 0; i < result.length; i++) {
            if (result3[i] == null) break;
			System.out.print(result[i].x + ", ");
            System.out.println(result[i].y);
		}
        */

		// window sum
        /*
        int[] A = new int[]{1,2,3,1,-1};
        int[] res = WindowSum.sumOfWindow(A, 6);
        for (int i : res) System.out.println(i);
        */

        // longest palindromic substring
        /*
        System.out.println(LongestPalindrome.longestPalindrome("abcbazc"));
        */

        // order dependency
        /*
        Order o1 = new Order("泡面");
        Order o2 = new Order("泡面");
        Order o3 = new Order("SF");
        Order o4 = new Order("租车");
        Order o5 = new Order("SF");
        Order o6 = new Order("泡面");
        Order o7 = new Order("租车");
        Order o8 = new Order("SF");
        Order o9 = new Order("爽(每个行为只输出了一次对吧)");
        OrderDependency od1 = new OrderDependency(o1, o3);
        OrderDependency od2 = new OrderDependency(o2, o7);
        OrderDependency od3 = new OrderDependency(o3, o9);
        OrderDependency od4 = new OrderDependency(o4, o3);
        OrderDependency od5 = new OrderDependency(o6, o9);
        OrderDependency od6 = new OrderDependency(o8, o9);
        OrderDependency od7 = new OrderDependency(o2, o5);

        List<OrderDependency> list = new ArrayList<>();
        list.add(od1);
        list.add(od2);
        list.add(od3);
        list.add(od4);
        list.add(od5);
        list.add(od6);
        list.add(od7);
        List<Order> res = OrderDependSolution.orderDependency(list);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i).orderName);
            if (i+1 < res.size()){
                System.out.print(" -> ");
            }
        }
        */

        // City connection
        /*
        List<Connection> connections = new ArrayList<>();
        connections.add(new Connection("A","B",6));
        connections.add(new Connection("B","C",4));
        connections.add(new Connection("C","D",5));
        connections.add(new Connection("D","E",8));
        connections.add(new Connection("E","F",1));
        connections.add(new Connection("B","F",10));
        connections.add(new Connection("E","C",9));
        connections.add(new Connection("F","C",7));
        connections.add(new Connection("B","E",3));
        connections.add(new Connection("A","F",1));
        List<Connection> res = CityConnection.getLowCost(connections);
        for (Connection c : res){
            c.printConnection();
        }
        */

        // company avg
        /*
        Node root = new Node(1);
        Node l21 = new Node(2);
        Node l22 = new Node(3);
        Node l23 = new Node(4);
        Node l31 = new Node(5);
        Node l32 = new Node(5);
        Node l33 = new Node(5);
        Node l34 = new Node(5);
        Node l35 = new Node(5);
        Node l36 = new Node(5);

        l21.children.add(l31);
        l21.children.add(l32);

        l22.children.add(l33);
        l22.children.add(l34);

        l23.children.add(l35);
        l23.children.add(l36);

        root.children.add(l21);
        root.children.add(l22);
        root.children.add(l23);

        Node res = CompanyTree.getHighAve(root);
        System.out.println(res.val); // 4
        */

        // high five
        /*
        Result r1 = new Result(1, 95);
        Result r2 = new Result(1, 95);
        Result r3 = new Result(1, 91);
        Result r4 = new Result(1, 91);
        Result r5 = new Result(1, 93);
        Result r6 = new Result(1, 105);

        Result r7 = new Result(2, 6);
        Result r8 = new Result(2, 6);
        Result r9 = new Result(2, 7);
        Result r10 = new Result(2, 6);
        Result r11 = new Result(2, 6);
        Result[] arr = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
        Map<Integer, Double> res = getHighFive(arr);

        System.out.println(res.get(1) + " " +res.get(2));
        */

    }
}
