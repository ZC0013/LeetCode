import org.junit.Test;

/**
 * @author zhangchuang
 * @create 2021-06-16 9:27 下午
 */
public class LeetCode877_Stone_Game {

    @Test
    public void test(){
        int[] stones = {5,3,4,5};
        boolean stoneGame = stoneGame(stones);
        System.out.println(stoneGame);
    }


    public boolean stoneGame(int[] ps) {
        int n = ps.length;
        int[][] f = new int[n + 2][n + 2];
        for (int len = 1; len <= n; len++) { // 枚举区间长度
            for (int l = 1; l + len - 1 <= n; l++) { // 枚举左端点
                int r = l + len - 1; // 计算右端点
                int a = ps[l - 1] - f[l + 1][r];
                int b = ps[r - 1] - f[l][r - 1];
                f[l][r] = Math.max(a, b);

            }
        }
        return f[1][n] > 0;
    }


}
