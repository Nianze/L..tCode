// Created by Rym on 10/20/2016
public class WordSearch {
    // dfs, O(M*N)
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++){
                if (exist(board, i, j, word, 0))
                    return true;
            }
        return false;
    }
    // O(4^k), k is the length of word
    private boolean exist(char[][] board, int i, int j, String word, int idx){
        if (idx == word.length()) return true;
        if (i > board.length-1 || i < 0 || j > board[0].length-1 || j < 0 || board[i][j] != word.charAt(idx))
            return false;
        board[i][j]='*'; // or: board[y][x] ^= 256;
        boolean result = exist(board, i - 1, j, word, idx + 1) ||
            exist(board, i, j - 1, word, idx + 1) ||
            exist(board, i, j + 1, word, idx + 1) ||
            exist(board, i + 1, j, word, idx + 1);
        board[i][j] = word.charAt(idx); // board[y][x] ^= 256;
        return result;
    }    
}
