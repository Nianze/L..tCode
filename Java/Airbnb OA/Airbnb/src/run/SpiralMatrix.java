package run;

import java.util.*;

public class SpiralMatrix {
    public static void main(String args[] ) throws Exception {        
        Scanner sc = new Scanner(System.in);
        String line;
        String[] lineVector;
        line = sc.nextLine();
        lineVector = line.split(",");
        int rowNum = Integer.valueOf(lineVector[0]);
        int colNum = Integer.valueOf(lineVector[1]);
        
        if (rowNum == 0 || colNum == 0) {
        	sc.close();
            return;
        }
        int[][] nums = new int[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
        	line = sc.nextLine();
        	lineVector = line.split(",");
            for (int j = 0; j < colNum; j++) {
                nums[i][j] = Integer.valueOf(lineVector[j]);
            }
        }
        sc.close();
        int upRow = 0, downRow = rowNum - 1;
        int leftCol = 0, rightCol = colNum - 1;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        while ( upRow <= downRow && leftCol <= rightCol) {
            for (int i = leftCol; i <= rightCol; i++) {
                ans.add(nums[upRow][i]);
            }
            upRow++;
            for (int i = upRow; i <= downRow; i++) {
                ans.add(nums[i][rightCol]);
            }
            rightCol--;
            if (upRow <= downRow) {
                for (int i = rightCol; i >= leftCol; i--) {
                    ans.add(nums[downRow][i]);
                }
                downRow--;
            }
            if (leftCol <= rightCol) {
                for (int i = downRow; i >= upRow; i--) {
                    ans.add(nums[i][leftCol]);
                }
                leftCol++;
            }
        }        
        boolean isFirst = true;
        for (int i : ans) {
            if (!isFirst) {
                System.out.print(",");
            }
            isFirst = false;
            System.out.print(i);
        }        
    }
}