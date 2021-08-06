import org.junit.Test;

import java.util.*;

/**
 * @Created by zhang on 2021/8/5  21:45
 */
public class LeetCode802_Find_Eventual_Safe_States {

    @Test
    public void eventualSafeNodes(){
        int[][] graph = new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> list = TopologicalSort(graph);
        System.out.println(list);

    }

    /**
     * 使用的是深度遍历法 + 三色标记法
     * 其中 0 代表未遍历节点
     *      1 代表正在遍历节点或者已经是环的节点
     *      2 表示是安全节点
     * @param graph 有向图
     * @return  返回的安全节点
     */
    public List<Integer> DFSThreeColourFlag(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (safe(graph, color, i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean safe(int[][] graph, int[] color, int x) {
        if (color[x] > 0) {
            return color[x] == 2;
        }
        color[x] = 1;
        for (int y : graph[x]) {
            if (!safe(graph, color, y)) {
                return false;
            }
        }
        color[x] = 2;
        return true;
    }

    /**
     * 方法二： 反向拓扑排序
     *
     */
    public List<Integer> TopologicalSort(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> rg = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; ++i) {
            rg.add(new ArrayList<Integer>());
        }
        int[] inDeg = new int[n];
        for (int x = 0; x < n; ++x) {
            for (int y : graph[x]) {
                rg.get(y).add(x);
            }
            inDeg[x] = graph[x].length;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (inDeg[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int y = queue.poll();
            for (int x : rg.get(y)) {
                if (--inDeg[x] == 0) {
                    queue.offer(x);
                }
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (inDeg[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }

}
