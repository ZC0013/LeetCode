import org.junit.Test;

/**
 * @Created by zhang on 2021/11/18  15:34
 */
public class LC91_解码方法_Y2 {


    @Test
    public void test(){
        int res = numDecodings("10");
        System.out.println(res);
    }
    public int numDecodings(String s) {
        int n = s.length();
        char[] ss = s.toCharArray();
        if( ss[0] == '0' ) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for( int i = 1; i < n; i++ ){
            int temp = (ss[i - 1] - '0') * 10 + (ss[i] - '0');
            if( ss[i] == '0' ){
                if( temp >= 10 && temp <= 26 ){
                    dp[i] = dp[i-1] - 1;
                    continue;
                }else{
                    return 0;
                }
            }
            if( temp >= 10 && temp <= 26 ) dp[i] = dp[i-1] + (i >= 2 ? dp[i-2] : 1);
            else dp[i] = dp[i-1];
        }
        return dp[n-1];
    }
}
