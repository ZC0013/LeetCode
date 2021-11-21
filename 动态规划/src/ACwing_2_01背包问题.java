import org.junit.Test;

/**
 * @Created by zhang on 2021/11/20  23:35
 */
public class ACwing_2_01背包问题 {


    @Test
    public void test(){

        int[] v = new int[]{0,1,2,3,4};
        int[] w = new int[]{0,2,4,4,5};
        int n = 4;
        int m = 5;
        int[] f = new int[m + 1];
        for( int i = 1; i <= n; i++ ){
            for( int j = m; j >= v[i]; j-- ){
                f[j] = Math.max( f[j], f[j - v[i]] + w[i]);
            }
        }
        System.out.println(f[m]);
    }

}
