import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @Created by zhang on 2021/9/16  19:40
 */
public class LC2dStringMatching {


    @Test
    public void test(){
//        char[][] board = new char[][]{
//                {'o','a','a','n'},
//                {'e','t','a','e'},
//                {'i','h','k','r'},
//                {'i','f','l','v'}
//
//        };
        char[][] board = new char[][]{{'a','b','c'},{'a','e','d'},{'a','f','g'}};
//        String[] words = new String[]{"oath","pea","eat","rain"};
        String[] words = new String[]{"eaabcdgfa","eaafgdcba"};
        List<String> list = findWords(board, words);
        System.out.println(list);
    }

    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;

        String b = String.valueOf(board[0]);
        List<String> res = new LinkedList<>();
        for (int i = 1; i < board.length; i++) {
            b += String.valueOf(board[i]);
        }
        for(String word : words){
            int index = -2;

            while( index == -2 || (index >= 0 && index < n*m)){
                index = b.indexOf(word.charAt(0), index+1);
                if( index >= 0 && index < n*m ){
                    boolean[][] views = new boolean[n][m];
                    boolean temp = find(word, board, views, index / m, index % m, 0, n, m);
                    if(temp){
                        res.add(word);
                        break;
                    }
                }
            }

        }
        return res;
    }

    public boolean find( String word, char[][] board, boolean[][] views, int n, int m, int w, int nn, int mm){

        if( w == word.length()){
            return true;
        }

        if( n >= 0 && n < nn && m >= 0 && m < mm){
            if(views[n][m] || word.charAt(w) != board[n][m]){
                return false;
            }
            views[n][m] = true;
            if(find(word, board, views, n-1, m,w+1,nn,mm)) return true;
            if(find(word, board, views, n+1, m,w+1,nn,mm)) return true;
            if(find(word, board, views, n, m-1,w+1,nn,mm)) return true;
            if (find(word, board, views, n, m+1,w+1,nn,mm)) return true;
            views[n][m] = false;
        }
        return false;
    }
}
