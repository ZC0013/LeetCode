import org.junit.Test;

import java.util.Arrays;

/**
 * @Created by zhang on 2021/8/18  19:09
 */
public class LeetCode552 {

    @Test
    public void test(){
        int i = checkRecord(3);
        System.out.println(i);
    }

    public int checkRecord(int n) {
        final int MOD = 1000000007;
        int[][][] dp = new int[n + 1][2][3]; // 长度，A 的数量，结尾连续 L 的数量
        dp[0][0][0] = 1;
        // i 表示 第几天 ;
        // j 表示 有几个A ;
        // k 表示结尾连续L的个数;
        for (int i = 1; i <= n; i++) {
            // 以 P 结尾的数量
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 2; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD;
                }
            }
            // 以 A 结尾的数量
            for (int k = 0; k <= 2; k++) {
                dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][k]) % MOD;
            }
            // 以 L 结尾的数量
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k <= 2; k++) {
                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD;
                }
            }
        }
        int sum = 0;
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 2; k++) {
                sum = (sum + dp[n][j][k]) % MOD;
            }
        }
        return sum;
    }

    //因为只会用到前一天的dp，所以可以进行空间优化
    public int dpPro(int n) {
        final int MOD = 1000000007;
        int[][] dp = new int[2][3]; // A 的数量，结尾连续 L 的数量
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int[][] dpNew = new int[2][3];
            // 以 P 结尾的数量
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 2; k++) {
                    dpNew[j][0] = (dpNew[j][0] + dp[j][k]) % MOD;
                }
            }
            // 以 A 结尾的数量
            for (int k = 0; k <= 2; k++) {
                dpNew[1][0] = (dpNew[1][0] + dp[0][k]) % MOD;
            }
            // 以 L 结尾的数量
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k <= 2; k++) {
                    dpNew[j][k] = (dpNew[j][k] + dp[j][k - 1]) % MOD;
                }
            }
            dp = dpNew;
        }
        int sum = 0;
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 2; k++) {
                sum = (sum + dp[j][k]) % MOD;
            }
        }
        return sum;
    }
    //    ************************状态转移矩阵****************************
    // 下面看看有存在多少可以拿到出勤奖励状态:
    // 状态1: 总缺勤数'A':0, 末尾连续迟到数'L':0
    // 状态2: 总缺勤数'A':0, 末尾连续迟到数'L':1
    // 状态3: 总缺勤数'A':0, 末尾连续迟到数'L':2
    // 状态4: 总缺勤数'A':1, 末尾连续迟到数'L':0
    // 状态5: 总缺勤数'A':1, 末尾连续迟到数'L':1
    // 状态6: 总缺勤数'A':1, 末尾连续迟到数'L':2

    // 下面这一堆是纸老虎, 看着很吓人, 其实都是非常简单朴素的逻辑:
    // 1. '今天'的状态1(cur_1): 总缺勤数'A':0, 末尾连续迟到数'L':0
    //     (1): 当'今天'正常出勤时, 可由'昨天'的状态1(pre_1), 状态2(pre_2), 状态3(pre_3)转移而来: cur_1 = pre_1 + pre_2 + pre_3
    //     (2): 当'今天'迟到时, 无法由任何'昨天'的状态转移而来
    //     (3): 当'今天'缺勤时, 无法由任何'昨天'的状态转移而来
    //     因为要同时考虑三种情况, 我们需要把这三种可转移状态数求和, 得到'今天'状态数: cur_1 = pre_1 + pre_2 + pre_3

    // 2. '今天'的状态2(cur_2): 总缺勤数'A':0, 末尾连续迟到数'L':1
    //     (1): 当'今天'正常出勤时, 无法由任何'昨天'的状态转移而来
    //     (2): 当'今天'迟到时, 可由'昨天'的状态1(pre_1)转移而来: cur_2 = pre_1
    //     (3): 当'今天'缺勤时, 无法由任何'昨天'的状态转移而来
    //     因为要同时考虑三种情况, 我们需要把这三种可转移状态数求和, 得到'今天'状态数: cur_2 = pre_1

    // 3. '今天'的状态3(cur_3): 总缺勤数'A':0, 末尾连续迟到数'L':2
    //     (1): 当'今天'正常出勤时, 无法由任何'昨天'的状态转移而来
    //     (2): 当'今天'迟到时, 可由'昨天'的状态2(pre_2)转移而来: cur_3 = pre_2
    //     (3): 当'今天'缺勤时, 无法由任何'昨天'的状态转移而来
    //     因为要同时考虑三种情况, 我们需要把这三种可转移状态数求和, 得到'今天'状态数: cur_3 = pre_2

    // 4. '今天'的状态4(cur_4): 总缺勤数'A':1, 末尾连续迟到数'L':0
    //     (1): 当'今天'正常出勤时, 可由'昨天'的状态4(pre_4), 状态5(pre_5), 状态6(pre_6)转移而来: cur_4 = pre_4 + pre_5 + pre_6
    //     (2): 当'今天'迟到时, 无法由任何'昨天'的状态转移而来
    //     (3): 当'今天'缺勤时, 可由'昨天'的状态1(pre_1), 状态2(pre_2), 状态3(pre_3)转移而来: cur_4 = pre_1 + pre_2 + pre_3
    //     因为要同时考虑三种情况, 我们需要把这三种可转移状态数求和, 得到'今天'状态数: cur_4 = pre_1 + pre_2 + pre_3 + pre_4 + pre_5 + pre_ 6

    // 5. '今天'的状态5(cur_5): 总缺勤数'A':1, 末尾连续迟到数'L':1
    //     (1): 当'今天'正常出勤时, 无法由任何'昨天'的状态转移而来
    //     (2): 当'今天'迟到时, 可由'昨天'的状态4(pre_4)转移而来: cur_5 = pre_4
    //     (3): 当'今天'缺勤时, 无法由任何'昨天'的状态转移而来
    //     因为要同时考虑三种情况, 我们需要把这三种可转移状态数求和, 得到'今天'状态数: cur_5 = pre_4

    // 6. '今天'的状态6(cur_6): 总缺勤数'A':1, 末尾连续迟到数'L':2
    //     (1): 当'今天'正常出勤时, 无法由任何'昨天'的状态转移而来
    //     (2): 当'今天'迟到时, 可由'昨天'的状态5(pre_5)转移而来: cur_6 = pre_5
    //     (3): 当'今天'缺勤时, 无法由任何'昨天'的状态转移而来
    //     因为要同时考虑三种情况, 我们需要把这三种可转移状态数求和, 得到'今天'状态数: cur_6 = pre_5
    static final int MOD = 1000000007;

    public int PPPRO(int n) {
        long[][] mat = {{1, 1, 0, 1, 0, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 0}};
        long[][] res = pow(mat, n);
        long sum = Arrays.stream(res[0]).sum();
        return (int) (sum % MOD);
    }

    public long[][] pow(long[][] mat, int n) {
        long[][] ret = {{1, 0, 0, 0, 0, 0}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, mat);
            }
            n >>= 1;
            mat = multiply(mat, mat);
        }
        return ret;
    }

    public long[][] multiply(long[][] a, long[][] b) {
        int rows = a.length, columns = b[0].length, temp = b.length;
        long[][] c = new long[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < temp; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                    c[i][j] %= MOD;
                }
            }
        }
        return c;
    }
}
