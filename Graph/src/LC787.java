import org.junit.Test;

import java.util.*;

/**
 * @Created by zhang on 2021/8/24  19:35
 * 有限制的有向图搜索
 */

public class LC787 {

    /*
    LC787. K 站中转内最便宜的航班
     */
    @Test
    public void test(){
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int cheapestPrice = findCheapestPrice(3, flights, 0, 2,1);
        System.out.println(cheapestPrice);
    }

    /*
    从src节点开始不断遍历
    记录遍历层数
    同时使用map存储每个src节点对应的元素集，简化搜索

    方法一： 暴力DFS，
        1. 首先遍历边矩阵，把所以的出发节点存到一个 map 集合中
            例如：此时 map 中 0 —— 0, 2   1 —— 1,其中key为出发节点，value为出去节点对应的flights矩阵
        2. 遍历src节点的出发矩阵，如果能在 k 步之内到达目标节点，就与记录的最小值比较返回较小值；如果超过 K 步就跳出递归。

     */
    Map<Integer, List<Integer>> map = new HashMap<>();
    int des, maxStep, min;
    int[][] temp;

    public int DFS(int n, int[][] flights, int src, int dst, int k) {
        for (int i = 0; i < flights.length; i++) {
            List<Integer> list = map.getOrDefault(flights[i][0], new ArrayList<>());
            list.add(i);
            map.put(flights[i][0], list);
        }
        des = dst;
        maxStep = k;
        min = Integer.MAX_VALUE;
        temp = flights;
        dfs(src, 0, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }


    public void dfs(int src, int step, int price) {
        //边界条件
        if (step > maxStep && src != des) {
            return;
        }
        if (src == des) {
            min = Math.min(price, min);
            return;
        }
        for (int num : map.getOrDefault(src, new ArrayList<>())
        ) {
            dfs(temp[num][1], step + 1, price + temp[num][2]);
        }
    }

    /*

    方法二：
    BFS 广度优先算法：从源节点开始，首先遍历源节点一次能到达的所有地方，并且更新源节点 src 到各个节点的 距离矩阵 vis[]

     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int INF = 0x3f3f3f3f;
        List<int[]>[] edge = new List[n];
        // 记录源节点 src 到各个节点的 距离矩阵 vis[]
        int[] vis = new int[n];
        for(int i = 0; i < n; ++i){
            edge[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            edge[flight[0]].add(new int[]{flight[1], flight[2]});
        }
        Arrays.fill(vis, INF);
        vis[src] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0, vis[src]});
        while (!queue.isEmpty()) {
            // poll[] 数组的含义：当前节点序号，当前的中转次数，从源节点到当前节点的消耗
            int[] poll = queue.poll();
            // 判断中转次数是否超过要求，要求最多 k 次中转
            if (poll[1] > k) break;
            for (int[] next : edge[poll[0]]) {  // next[] 数组：当前节点的所有通路：序号 消耗
                // 有点类似于迪杰斯特拉算法的更新，主要就是 当 源节点到当前节点的值 + 当前节点值到目标节点值 <= 源节点到目标节点值时，对距离值更新
                if (vis[next[0]] > poll[2] + next[1]) {
                    vis[next[0]] = poll[2] + next[1];
                    queue.add(new int[]{next[0], poll[1] + 1, vis[next[0]]});
                }
            }
        }
        return vis[dst] == INF ? -1 : vis[dst];
    }


}
