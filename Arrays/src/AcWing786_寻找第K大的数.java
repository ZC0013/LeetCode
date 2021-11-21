import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Created by zhang on 2021/11/21  21:34
 */
public class AcWing786_寻找第K大的数 {

    public static void main( String[] args ) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String[] str1 = br.readLine().split(" ");
        int n = Integer.parseInt( str1[0] );
        int k = Integer.parseInt( str1[1] );
        String[] str2 = br.readLine().split(" ");
        int[] num = new int[n];
        for( int i = 0; i < n; i++ ){
            num[i] = Integer.parseInt( str2[i] );
        }
        int res = findK( num, 0, n - 1, k - 1);
        System.out.println( res );
    }
    public static int findK( int[] num, int l, int r, int k){
        if( l > r ) return -1;
        int cur = l + r >>> 1;
        int i = l - 1, j = r + 1, x = num[ cur ];
        while( i < j ){
            do i ++; while( num[i] < x );
            do j --; while( num[j] > x );
            if( i < j ){
                int t = num[i];
                num[i] = num[j];
                num[j] = t;
            }
        }
        if( cur == j ){
            return num[cur];
        }else if( cur < j ){
            return findK( num, l, j, k);
        }else{
            return findK( num, j + 1, r, k);
        }
    }
}
