import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangchuang
 * @create 2021-10-30 3:18 下午
 */
public class LC260_只出现一次的数字III {

    @Test
    public void test(){
        int[] ints = singleNumber2(new int[]{1, 2, 1, 3, 2, 5});
        System.out.println(Arrays.toString(ints));

    }
    // 方法一：
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        if( n == 2 ) return nums;
        Arrays.sort(nums);
        int[] res = new int[2];
        int c = 0;
        for( int i = 0; i < n - 1; ){
            if( nums[i] != nums[i+1]){
                res[c++] = nums[i];
                i++;
            }else{
                i += 2;
            }
        }
        if( nums[n - 1] != nums[n-2]){
            res[1] = nums[n-1];
        }
        return res;
    }
    // 方法二：
    public int[] singleNumber2(int[] nums) {

        int ret = 0;
        for( int num : nums){
            ret ^= num;
        }
        int lowbit = (ret == Integer.MIN_VALUE ? ret : ret & (-ret));
        int num1 = 0;
        int num2 = 0;
        for( int n : nums ){
            if( (n & lowbit) == 0){
                num1 ^= n;
            }else{
                num2 ^= n;
            }
        }
        return new int[]{num1,num2};
    }

    int lowbit(int n){
        return n&(-n);
    }


}
