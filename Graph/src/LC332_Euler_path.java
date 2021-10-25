import org.junit.Test;

import java.util.*;

/**
 * @Created by zhang on 2021/10/25  16:42
 */
public class LC332_Euler_path {

    /*
    LC332. 重新安排行程
    给定一个 n 个点 m 条边的图，要求从指定的顶点出发，经过所有的边恰好一次（可以理解为给定起点的「一笔画」问题），使得路径的字典序最小。

    这种「一笔画」问题与欧拉图或者半欧拉图有着紧密的联系，下面给出定义：
        1.通过图中所有边恰好一次且行遍所有顶点的通路称为欧拉通路。
        2.通过图中所有边恰好一次且行遍所有顶点的回路称为欧拉回路。
        3.具有欧拉回路的无向图称为欧拉图。
        4.具有欧拉通路但不具有欧拉回路的无向图称为半欧拉图。

     */

    @Test
    public void Euler_path(){
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK","KUL"));
        tickets.add(Arrays.asList("JFK","NRT"));
        tickets.add(Arrays.asList("NRT","JFK"));
        List<String> itinerary = findItinerary2(tickets);
        System.out.println(itinerary);
    }

    /*
    方法一： DFS
    其中用 Map<String, List<String>> graph 记录结点和他所的相邻结点
    然后对于 graph 中的 List<String> 按字符排序，字符序小的排前边
    特点：题主对于API的使用达到了炉火纯青的地步

    Hierholzer 算法：用于在连通图中寻找欧拉路径，其流程如下：
        1.从起点出发，进行深度优先搜索。
        2.每次沿着某条边从某个顶点移动到另外一个顶点的时候，都需要删除这条边。
        3.如果没有可移动的路径，则将所在节点加入到栈中，并返回。

    graph.computeIfAbsent()   Map的 computeIfAbsent 方法，如果 key 存在，则返回对应的value，
                              否则执行对应的方法添加为value

     */
    public List<String> findItinerary(List<List<String>> tickets) {
        // 因为逆序插入，所以用链表
        List<String> ans = new LinkedList<>();
        if (tickets == null || tickets.size() == 0)
            return ans;
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> pair : tickets) {
            // 因为涉及删除操作，我们用链表
            List<String> nbr = graph.computeIfAbsent(pair.get(0), k -> new LinkedList<>());
            nbr.add(pair.get(1));
        }
        // 按目的顶点排序
        graph.values().forEach(x -> x.sort(String::compareTo));
        visit(graph, "JFK", ans);
        return ans;
    }
    // DFS方式遍历图，当走到不能走为止，再将节点加入到答案
    private void visit(Map<String, List<String>> graph, String src, List<String> ans) {
        List<String> nbr = graph.get(src);
        while (nbr != null && nbr.size() > 0) {
            String dest = nbr.remove(0);
            visit(graph, dest, ans);
        }
        ans.add(0, src); // 逆序插入
    }

    /*
    方法二： DFS 使用 PriorityQueue<String> 代替排序，降低时间复杂度
    其中用 Map<String, PriorityQueue<String>> graph 记录结点和他所的相邻结点
    然后对于 graph 中的 List<String> 按字符排序，字符序小的排前边
     */
    public List<String> findItinerary2(List<List<String>> tickets) {
        // 因为逆序插入，所以用链表
        List<String> ans = new LinkedList<>();
        if (tickets == null || tickets.size() == 0)
            return ans;
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> pair : tickets) {
            // 因为涉及删除操作，我们用链表
            PriorityQueue<String> nbr = graph.computeIfAbsent(pair.get(0), k -> new PriorityQueue<>());
            nbr.add(pair.get(1));
        }
        visit2(graph, "JFK", ans);
        return ans;
    }
    // DFS方式遍历图，当走到不能走为止，再将节点加入到答案
    private void visit2(Map<String, PriorityQueue<String>> graph, String src, List<String> ans) {
        PriorityQueue<String> nbr = graph.get(src);
        while (nbr != null && nbr.size() > 0) {
            String dest = nbr.poll();
            visit2(graph, dest, ans);
        }
        ans.add(0, src); // 逆序插入
    }




}
