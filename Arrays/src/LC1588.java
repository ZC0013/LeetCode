import org.junit.Test;

import java.util.HashMap;

/**
 * @Created by zhang on 2021/8/29  13:58
 */
public class LC1588 {


    @Test
    public void test(){
        int[] arr = {1,4,2,5,3};
        int i = sumOddLengthSubarrays(arr);
        System.out.println(i);
    }
    public int sumOddLengthSubarrays(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        int c = 1;
        int res = 0;

        if( n < 3){
            for(int i = 0; i < n; i++){
                res += arr[i];
            }
            return res;
        }
        while( c <= n){
            for(int i = 0; i + c <= n; i++){
                if( c == 1 ){
                    res += arr[i];
                }else{
                    int tem = 0;
                    tem += map.getOrDefault(i,arr[i]);
                    for(int j = i+c-2, t = c; t > c-2; j++, t-- ){
                        tem += arr[j];
                    }
                    map.put(i,tem);
                    res += tem;
                }
            }
            c += 2;
        }
        return res;
    }
}
