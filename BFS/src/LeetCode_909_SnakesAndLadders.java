import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC909 蛇梯棋
 * 难度：中等
 *
 * @author zhangchuang
 * @create 2021-06-27 2:30 下午
 */
public class LeetCode_909_SnakesAndLadders {

    /*
    题目描述：
        我们可以将棋盘抽象成一个包含 N^2个节点的有向图，对于每个节点 x，若 x+i (1 <= i <= 6)上没有蛇或梯子，
        则连一条从 x 到 x+i 的有向边；否则记蛇梯的目的地为 y，连一条从 x 到 y 的有向边。
    故：原问题等价于在这张有向图上求出从 1 到 N^2 的最短路长度
    最短路径用 BFS ，能否到达使用 DFS

    使用 BFS 将每次的移动都存放到一个队列 queue 中，每次存放一个数组(当前位置，当前移动次数)
     */
    @Test
    public void test(){
        int[][] board = new int[][]{
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}
        };
        int num = snakesAndLadders(board);
        System.out.println(num);

    }

    /*

     */
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 1; i <= 6; ++i) {
                int nxt = p[0] + i;
                if (nxt > n * n) { // 超出边界
                    break;
                }
                int[] rc = id2rc(nxt, n); // 得到下一步的行列
                if (board[rc[0]][rc[1]] > 0) { // 存在蛇或梯子
                    nxt = board[rc[0]][rc[1]];
                }
                if (nxt == n * n) { // 到达终点
                    return p[1] + 1;
                }
                if (!vis[nxt]) {
                    vis[nxt] = true;
                    queue.offer(new int[]{nxt, p[1] + 1}); // 扩展新状态
                }
            }
        }
        return -1;
    }

    /**
     * 起到 当前数字 id ----> 坐标位置
     * @param id    当前数字位置
     * @param n     矩阵的边长
     * @return      坐标数组[ ]
     */
    public int[] id2rc(int id, int n) {
        int r = (id - 1) / n, c = (id - 1) % n;
        // 行号为奇数和偶数是要坐标互换
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        // r 为 行数，因为数字是从左下角开始，所以是 n - i - r;
        return new int[]{n - 1 - r , c};
    }
}
