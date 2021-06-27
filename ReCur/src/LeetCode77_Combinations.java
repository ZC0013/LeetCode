import org.junit.Test;

import java.util.*;

/**
 * @author zhangchuang
 * @create 2021-06-07 10:07 上午
 */
public class LeetCode77_Combinations {

    @Test
    /**
     * 方法一回溯法
     * 分析搜索起点的上界进行剪枝
     */
    public void test1(){

        List<List<Integer>> combine = combine1(5, 3);
        System.out.println(combine);
    }

    List<List<Integer>> result1 = new ArrayList<>();
    LinkedList<Integer> path1 = new LinkedList<>();
    public List<List<Integer>> combine1(int n, int k) {
        combineHelper1(n, k, 1);
        return result1;
    }

    /**
     * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
     * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
     */
    private void combineHelper1(int n, int k, int startIndex){
        //终止条件
        if (path1.size() == k){
            result1.add(new ArrayList<>(path1));
            return;
        }
        for (int i = startIndex; i <= n - (k - path1.size()) + 1; i++){
            path1.add(i);
            combineHelper1(n, k, i + 1);
            path1.removeLast();
        }
    }

}
