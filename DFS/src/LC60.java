import org.junit.Test;

import java.util.Arrays;

/**
 * @Created by zhang on 2021/10/27  20:24
 */
public class LC60 {

    @Test
    public void test(){

        String permutation = getPermutation1(3, 2);
        System.out.println(permutation);
    }


    /*
    方法二： 用循环替代递归
    很厉害
     */

    public String getPermutation1(int n, int k) {
        final int[] arr = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(visited, false);
        StringBuilder permutation = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int cnt = arr[i];
            for (int j = 1; j <= n; j++) {
                if (visited[j]) {
                    continue;
                }
                if (k > cnt) {
                    k -= cnt;
                    continue;
                }
                visited[j] = true;
                permutation.append(j);
                break;
            }
        }
        return permutation.toString();
    }


    /**
     * 记录数字是否使用过
     */
    private boolean[] used;

    /**
     * 阶乘数组
     */
    private int[] factorial;

    private int n;
    private int k;

    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        calculateFactorial(n);

        // 查找全排列需要的布尔数组
        used = new boolean[n + 1];
        Arrays.fill(used, false);

        StringBuilder path = new StringBuilder();
        dfs(0, path);
        return path.toString();
    }


    /**
     * @param index 在这一步之前已经选择了几个数字，其值恰好等于这一步需要确定的下标位置
     * @param path
     */
    private void dfs(int index, StringBuilder path) {
        if (index == n) {
            return;
        }

        // 计算还未确定的数字的全排列的个数，第 1 次进入的时候是 n - 1
        int cnt = factorial[n - 1 - index];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            path.append(i);
            used[i] = true;
            dfs(index + 1, path);
            // 注意 1：不可以回溯（重置变量），算法设计是「一下子来到叶子结点」，没有回头的过程
            // 注意 2：这里要加 return，后面的数没有必要遍历去尝试了
            return;
        }
    }

    /**
     * 计算阶乘数组
     *
     * @param n
     */
    private void calculateFactorial(int n) {
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }



}
