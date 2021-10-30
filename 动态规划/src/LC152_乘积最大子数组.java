import org.junit.Test;

/**
 * @Created by zhang on 2021/10/29  23:02
 */
public class LC152_乘积最大子数组 {

    /*
    标签 ： 动态规划
     */
    @Test
    public void test(){
        int i = maxProduct(new int[]{2,3,-2,4,-2});
        System.out.println(i);
    }

    /*
    由于负数的存在，导致最大的会变最小，最小的会变最大，因此还需要维护当前的最小值 imin
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }

}
