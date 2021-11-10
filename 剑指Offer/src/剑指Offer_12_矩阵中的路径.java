import org.junit.Test;

/**
 * @Created by zhang on 2021/11/7  22:50
 */
public class 剑指Offer_12_矩阵中的路径 {
    /*
    给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
    能否到达问题一般都是使用 DFS ， BFS 用于最短路径
    解决方法：DFS + 剪切
     */

    @Test
    public void test(){
        char[][] board = new char[][]{
                {'a','b'}

        };
        boolean res = exist(board, "ba");
        System.out.println(res);

    }

    public boolean exist(char[][] board, String word) {

        for( int i = 0; i < board.length; i++){
            for( int j = 0; j < board[0].length; j++){
                if( dfs( board, word, i, j, 0) ){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs( char[][] board, String word, int i, int j, int c){
        if( i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(c) ){
            return false;
        }
        if( c == word.length() - 1){
            return true;
        }
        board[i][j] = '\0';
        boolean res = dfs(board, word, i-1,j,c+1) || dfs(board, word, i+1,j,c+1) || dfs(board, word, i,j-1,c+1) || dfs(board, word, i,j+1,c+1);
        board[i][j] = word.charAt(c);
        return res;
    }
}
