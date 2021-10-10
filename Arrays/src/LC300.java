import org.junit.Test;

import java.util.Arrays;

/**
 * @Created by zhang on 2021/9/23  16:50
 */
public class LC300 {

    @Test
    public void test(){
         int[] nums = new int[]{1,8,4,12,2,13};
        int lis = Greed2(nums);
        System.out.println(lis);
    }

    /*
    官方贪心
     */
    public int Greed2(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                int l = 1, r = len, pos = 0; 
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

    /*
    贪心 + 二分
     */
    public int Greed(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
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

    /*
    动态规划
     */
    public int DP(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    /*
    方法超时：
    暴力迭代法
     */
    int num, max;
    public int lengthOfLIS(int[] nums) {
        num = nums.length;
        max = nums[0];
        int res = 0;
        for (int i = 1; i < num; i++) {
            max = Math.max(nums[i], max);
        }
        for (int i = 0; i < num; i++) {
            int temp = DFS(i,1,nums);
            res = Math.max(temp,res);
        }

        return res;
    }

    public int DFS(int index, int count, int[] nums){
        int res = count;
        if( index == num) return res;

        for (int i = index+1; i < num; i++) {
            if( nums[i] > nums[index] ){
                res = Math.max(DFS(i, count + 1, nums),res);
            }
        }

        return res;

    }

}
