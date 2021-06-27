import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangchuang
 * @create 2021-06-08 2:54 下午
 */
public class LeetCode377_Combinations4 {

    @Test
    public void test(){
        int[] arr = {3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
        int i = combinationSum4(arr, 10);
        System.out.println(i);
    }

    int[] mome;
    int res = 0;
    public int combinationSum4(int[] nums, int target) {
        mome = new int[target+1];
        Arrays.fill(mome, -1);
        return recur(nums, target);
    }

    int recur(int[] nums, int target){

        if(target == 0) return 1;
        if(mome[target] != -1) return mome[target];
        for(int i = 0; i < nums.length; i++){
            if( target - nums[i] >= 0){
                res += recur(nums, target - nums[i]);
            }
        }
        mome[target] = res;
        return res;
    }
}
