import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Created by zhang on 2021/10/30  0:13
 */
public class LC1856_子数组最小乘积的最大值 {

    @Test
    public void test(){

        int i = maxSumMinProduct(new int[]{1,2,3,2});
        System.out.println(i);
    }

    public int maxSumMinProduct(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        // 对于每一个i 找到右侧连续的不小于它的元素，记录最后一个连续的，不小于它的元素对应下标
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){right[stack.pop()] = i-1;}
            stack.push(i);//存放的是下标
        }
        while(!stack.isEmpty()){right[stack.pop()] = len-1;}

        // 对于每一个i 找到左侧连续的不小于它的元素，记录最后一个连续的，不小于它的元素对应下标
        for(int i = len-1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){left[stack.pop()] = i+1;}
            stack.push(i);//存放的是下标
        }
        while(!stack.isEmpty()){left[stack.pop()] = 0;}

        //前缀和,用long来存放，防止相加时溢出
        long[] dp = new long[len];
        dp[0] = nums[0];
        for(int i = 1; i < len; i++){dp[i] = dp[i-1] + nums[i];}

        long result = 0;
        for(int i = 0; i < len; i++){
            result = Math.max(result, nums[i]*(dp[right[i]]-dp[left[i]]+nums[left[i]]));
        }//right[i]为右坐标 left[i]为左坐标，从left[i]到right[i]所有元素的和应该是dp[right[i]]-dp[left[i]]+nums[left[i]]
        return (int)(result%1000000007);
    }

}
