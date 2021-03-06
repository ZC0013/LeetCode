import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Created by zhang on 2021/8/9  21:47
 */
public class LC313_Super_Ugly_Number {


    @Test
    public void nthSuperUglyNumber() {
        int[] num = new int[]{2, 7, 13, 19};
        int i = DP(6, num);
        System.out.println(i);
    }

    /**
     * 使用 PriorityQueue 优先队列的最小堆数据结构
     * 本质上是一个完全二叉树，优先队列的作用是能保证每次取出的元素都是队列中权值最小的 ( 这里不自己构造比较器的话，默认为自然排序)
     * <p>
     * 用一个 HashSet 实现产生丑数的不重复
     * 用一个 PriorityQueue 实现输出的每次都是最小的丑数
     *
     * @param n      第几个超级丑数
     * @param primes 丑数的质数数组
     * @return 返回第 n 个丑数值
     */
    public int smallHeap(int n, int[] primes) {
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int prime : primes) {
                long next = curr * prime;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }


    /**
     * 动态规划 节约空间时间 避免重复的计算丑数
     * @param n         第几个超级丑数
     * @param primes    丑数的质数数组
     * @return          返回第 n 个丑数值
     */
    public int DP(int n, int[] primes) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int m = primes.length;
        int[] pointers = new int[m];
        Arrays.fill(pointers, 1);
        for (int i = 2; i <= n; i++) {
            int[] nums = new int[m];
            int minNum = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                nums[j] = dp[pointers[j]] * primes[j];
                minNum = Math.min(minNum, nums[j]);
            }
            dp[i] = minNum;
            for (int j = 0; j < m; j++) {
                if (minNum == nums[j]) {
                    pointers[j]++;
                }
            }
        }
        return dp[n];
    }

}
