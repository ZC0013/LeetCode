import org.junit.Test;

import java.util.*;

/**
 * @Created by zhang on 2021/11/12  12:52
 */
public class LC773_华容道 {


    @Test
    public void test(){
        int res = slidingPuzzle(new int[][]{
                {1, 2, 3},
                {5, 4, 0}
        });
        System.out.println(res);
    }

    int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle2(int[][] board) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                sb.append(board[i][j]);
            }
        }
        String initial = sb.toString();
        if ("123450".equals(initial)) {
            return 0;
        }

        int step = 0;
        Queue<String> queue = new LinkedList<String>();
        queue.offer(initial);
        Set<String> seen = new HashSet<String>();
        seen.add(initial);

        while (!queue.isEmpty()) {
            ++step;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String status = queue.poll();
                for (String nextStatus : get(status)) {
                    if (!seen.contains(nextStatus)) {
                        if ("123450".equals(nextStatus)) {
                            return step;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }

        return -1;
    }

    // 枚举 status 通过一次交换操作得到的状态
    public List<String> get(String status) {
        List<String> ret = new ArrayList<String>();
        char[] array = status.toCharArray();
        int x = status.indexOf('0');
        for (int y : neighbors[x]) {
            swap(array, x, y);
            ret.add(new String(array));
            swap(array, x, y);
        }
        return ret;
    }

    public void swap(char[] array, int x, int y) {
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public int slidingPuzzle(int[][] board) {
        // 预处理
        int[][] neighbor = new int[][]{
                {1,3},
                {0,4,2},
                {1,5},
                {0,4},
                {3,1,5},
                {4,2}
        };
        int m = 2, n = 3;
        StringBuilder sb = new StringBuilder("");
        String target = "123450";
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        // BFS 框架
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(start);
        visited.add(start);
        int step = 0;
        while( !q.isEmpty() ){
            int size = q.size();
            for( int i = 0; i < size; i++){
                String cur = q.poll();
                if( target.equals(cur) ){
                    return step;
                }
                int idx = cur.indexOf("0");
                char b = cur.charAt(idx);
                for( int adj : neighbor[idx]){
                    StringBuilder new_board = new StringBuilder(cur);
                    char a = new_board.charAt(adj);
                    new_board.setCharAt( adj, b);
                    new_board.setCharAt( idx, a);
                    String next_state = new_board.toString();
                    if( !visited.contains(next_state) ){
                        q.add(next_state);
                        visited.add(next_state);
                    }
                }

            }
            step++;
        }
        return -1;
    }
}
