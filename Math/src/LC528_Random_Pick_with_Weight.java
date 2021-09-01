import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

/**
 * @Created by zhang on 2021/8/30  20:07
 */
public class LC528_Random_Pick_with_Weight {


    @Test
    // 自己解决
    public void test(){

        int[] arr = {3,14,1,7};
        int sum = Arrays.stream(arr).sum();
        // 切记 +1，因为(int)向下取整，所以理论上取不到 sum 这个值，所以需要加1
        int tem = (int)(Math.random() * sum) + 1;

        System.out.println(tem);
        int index = 0;
        while (tem > 0){
            tem -= arr[index++];
        }
        System.out.println( index < 0 ? 0 : index-1);
    }

    @Test
    /*
    官方优化，主要优化在如何快速定位到随机数的位置，
    上面的方法采用的是从前往后顺序查找，所以时间复杂度较高；
    优化：前缀和数组 + 二分查找
     */
    public void test2(){

        int[] arr = {4,2};
        int sum = Arrays.stream(arr).sum();
        // 切记 +1，因为(int)向下取整，所以理论上取不到 sum 这个值，所以需要加1
        int tem = (int)(Math.random() * sum) + 1;

        int[] pre = new int[arr.length];
        pre[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            pre[i] = pre[i-1] + arr[i];
        }
        int search = binarySearch(pre, tem);
        System.out.println(search);

    }
    public int binarySearch(int[] pre, int num){
        int l = 0, r = pre.length - 1;
        while (l < r){
            int mid = ( l + r ) / 2;
            if(num < pre[mid]){
                r = mid - 1;
            }else if( num > pre[mid] ){
                l = mid + 1;
            }else {
                return mid;
            }
        }
        return r < 0 ? 0 : r;
    }
}
