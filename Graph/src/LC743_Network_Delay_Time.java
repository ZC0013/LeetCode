import org.junit.Test;

import java.util.Arrays;

public class LC743_Network_Delay_Time {

    /**
     * 题目的核心思想为：单源最短路问题
     *      可以使用 Dijkstra 算法
     * @author zhangchuang
     * @create 2021-08-02 17:00 下午
     */
    @Test
    public void networkDelayTime(){
        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};

        int dijkstra = Dijkstra(times, 4, 2);
        System.out.println(dijkstra);
    }


    /**
     * 解法一： Dijkstra 算法
     * @param times 表示信号经过有向边的传递时间。
     *        times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
     * @param n 有 n 个网络节点
     * @param k 从某个节点 k 发出一个信号。需要多久才能使所有节点都收到信号
     * @return  需要多久才能使所有节点都收到信号
     */
    public int Dijkstra(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;

        // 邻接矩阵存储边信息
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], INF);
        }
        for (int[] t : times) {
            // 边序号从 0 开始
            int x = t[0] - 1, y = t[1] - 1;
            g[x][y] = t[2];
        }

        // 从源点到某点的距离数组
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        // 由于从 k 开始，所以该点距离设为 0，也即源点
        dist[k - 1] = 0;

        // 节点是否被更新数组
        boolean[] used = new boolean[n];

        for (int i = 0; i < n; ++i) {
            // 在还未确定最短路的点中，寻找距离最小的点
            int x = -1;
            for (int y = 0; y < n; ++y) {
                if (!used[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }

            // 用该点更新所有其他点的距离
            used[x] = true;
            for (int y = 0; y < n; ++y) {
                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
            }
        }

        // 找到距离最远的点
        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }

}
