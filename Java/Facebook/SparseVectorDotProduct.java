// Created By Rym on 11/13/2016

public class SparseVectorDotProduct {
    public int dotProduct(int[] v1, int[] v2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < v1.length; i++) {
            if (v1[i] != 0) map.put(i, v1[i]);
        }
        for (int j = 0; j < v2.length; j++) {
            if (v2[j] != 0 && map.containsKey(j)) ans += map.get(j) * v2[j];
        }
        return ans;
    }

    // Use array + two pointer
    public int dotProduct(int[][] v1, int[][] v2) {
        int i = 0, j = 0, ans = 0;
        while (i < v1.length && j < v2.length) {
            if (v1[i][0] == v2[j][0]) ans += v1[i][1] * v2[j][1];
            else if (v1[i][0] < v2[j][0]) i++;
            else j++;
        }
    }
}
