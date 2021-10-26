import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Created by zhang on 2021/10/25  20:27
 */
public class LC753_Euler_Path2 {
    /*
    LC753. 破解保险箱
    举例：n=2,k=2,密码是00 01 10 11,因此需要找到一个组合能包含这些所有的组合，当每次输入的时候，最后的n个数可以尝试解密码
    答案是00110

    当输入0的时候，没有操作
    再次输入0，组合成00，这时候可以匹配到00
    再次输入1，组合成001，这时候01可以匹配到01
    再次输入1，组合成0011，这时候11可以匹配到11
    再次输入0，组合成00110，这时候10可以匹配到10

    仍然是利用 Hierholzer 算法 实现 一笔画

     */

    @Test
    public void test(){

        String s = crackSafe(3, 2);

        System.out.println(s);
    }

    Set<Integer> seen = new HashSet<Integer>(); // 用来去重，效率比 visit[] 高很多 可实现 O(1) 时间复杂度的去重
    StringBuffer ans = new StringBuffer();  // 用于记录答案的逆序，用 StringBuffer 方便添加
    int highest;
    int k;

    public String crackSafe(int n, int k) {
        highest = (int) Math.pow(10, n - 1);    /* 节点个数 */
        this.k = k;
        /* 从 n -1 个 0 的节点开始寻找 */
        dfs(0);
        /*
        设定的起点为 n-1 个 0
        补充起始节点字符串
        */
        for (int i = 1; i < n; i++) {
            ans.append('0');
        }
        ans.reverse();      // 按照 Hierholzer 算法 逆序输出为答案
        return ans.toString();
    }

    public void dfs(int node) {
        for (int x = 0; x < k; ++x) {   // 每个节点的 k 条边
            int nei = node * 10 + x;
            if (!seen.contains(nei)) {
                /*
                seen 内存的 nei 表示的是 边的访问 例如：
                01(1) -> 11 表示为 011 = 11
                11(0) -> 10 表示为 110
                如果数字在 HashSet中存在，则表示该边已经访问过
                */
                seen.add(nei);
                dfs(nei % highest);
                ans.append(x);
            }

        }

    }

}
