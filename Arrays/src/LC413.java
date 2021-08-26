import org.junit.Test;

/**
 * @Created by zhang on 2021/8/22  18:39
 */
public class LC413 {

    @Test
    public void test(){
        int[] nums = new int[]{1,3,5,5};
        int i = numberOfArithmeticSlices(nums);
        System.out.println(i);
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n < 3) return 0;
        int res = 0;

        int count = 1;
        for(int i = 0; i <= n-3; i++){
            int bew = nums[i+1] - nums[i];
            count = 1;
            for(int j = i + 1; j < n; j++){
                if(bew == (nums[j] - nums[j-1])){
                    count++;
                }else{
                    break;
                }
                if(count > 2) res++;
            }
        }
        return res;
    }
}
