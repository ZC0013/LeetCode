import org.junit.Test;

/**
 * @Created by zhang on 2021/10/29  23:24
 */
public class LC1191_K次串联后最大子数组之和 {

    @Test
    public void test(){
        int i = kConcatenationMaxSum(new int[]{-12,-10,55,66,-17,-18}, 2);
        System.out.println(i);
    }

    public int kConcatenationMaxSum(int[] arr, int k) {
        int max = 0;
        int imax = 0;
        long mod = 1000000007;
        int n = arr.length;
        for(int i = 0; i < k * n; i++){
            imax = (int)Math.max( (imax + arr[i % n]) % mod, arr[i % n]);
            max = Math.max(imax, max);
        }
        return max;
    }
}
