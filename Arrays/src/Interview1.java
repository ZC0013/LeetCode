import org.junit.Test;

import java.util.Arrays;

/**
 * @Created by zhang on 2021/9/7  20:22
 */
public class Interview1 {

    @Test
    public void test(){

        int[] nums = new int[]{1,2,3,3};
        int[] ints = find(nums);
        System.out.println(Arrays.toString(ints));
    }

    public int[] find(int[] nums){
        Arrays.sort(nums);
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if( nums[i] == temp){
                return new int[]{temp, temp+1};
            }
            temp = nums[i];
        }

        return new int[2];

    }
}
