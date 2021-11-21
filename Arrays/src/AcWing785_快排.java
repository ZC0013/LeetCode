import org.junit.Test;

import java.util.Arrays;

/**
 * @Created by zhang on 2021/11/21  16:36
 */
public class AcWing785_快排 {

    @Test
    public void test(){
        int[] num = new int[]{2,4, 1, 5, 3};
        quickSort(num, 0, num.length - 1);
        System.out.println(Arrays.toString(num));
    }

    public void quickSort( int[] arr, int l, int r){
        if( l >= r ) return;
        int i = l - 1, j = r + 1, x = arr[l + r >>> 1];
        while( i < j ){
            do i ++ ; while( arr[i] < x );
            do j -- ; while( arr[j] > x );
            if( i < j ){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        quickSort( arr, l, j);
        quickSort( arr, j + 1, r);
    }
}
