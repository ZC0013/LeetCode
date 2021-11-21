import org.junit.Test;

/**
 * @Created by zhang on 2021/11/18  17:18
 */
public class LC300_最长递增子序列_Y5 {

    @Test
    public void test(){
        int res = lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(res);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        for( int i = 1; i <= n; i++ ){
            dp[i] += 1;
            int t = 0;
            for( int j = 1; j < i; j++ ){
                if( nums[i-1] > nums[j-1] ) {
                    t = Math.max( dp[i], dp[i] + dp[j]);
                }
                dp[i] = t;
            }

        }
        int res = 0;
        for( int i = 1; i <= n; i++ ){
            res = Math.max( res, dp[i]);
        }
        return res;
    }
}
