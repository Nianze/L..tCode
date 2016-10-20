// Created by Rym on 10/16/2016
public class NumberOfIslands {
    // Follow up:
    //http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=205656&page=1&authorid=95843    
    //1.原matrix最后不要修改，但是要保证不用额外空间。-> 改成'-1'而不是0，之后再恢复
    //2. 然后是怎么保证线程安全，以及如果有多个请求，怎么加速
    //http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=205344&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
    //要求island unique shape，不考虑旋转：记录BFS路径，再用hashSet判重
    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }    
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
}
