import org.junit.Test;

/**
 * @Created by zhang on 2021/11/12  22:19
 */
public class LC300_最长递增子序列 {

    @Test
    public void test(){
        int res = lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 21, 18});
        System.out.println(res);
    }

    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            // 在tails中寻找第一个大于 num 的下标
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }

}
