import org.junit.Test;

/**
 * @Created by zhang on 2021/10/10  22:35
 */
public class LC441 {

    @Test
    public void test(){
        int res = arrangeCoins(2147483647);
        System.out.println(res);
    }


    public int arrangeCoins(int n) {
        int l = 1, r = n;
        int m = 1;
        long count = 0;
        while( l <= r ){
            m = (r - l + 1) / 2 + l;
            count = (long)( 1 + m ) * m / 2;
            if( count < n ){
                l = m + 1;
            }else if( count > n ){
                r = m - 1;
            }else{
                return m;
            }
        }
        return l-1;

    }
}
