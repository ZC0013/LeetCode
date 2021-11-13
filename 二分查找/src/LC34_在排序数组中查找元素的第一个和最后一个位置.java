import org.junit.Test;

/**
 * @Created by zhang on 2021/11/13  10:28
 */
public class LC34_在排序数组中查找元素的第一个和最后一个位置 {

    @Test
    public void test(){
        searchRange(new int[]{5,7,7,8,8,10}, 8);
    }
    public int[] searchRange(int[] nums, int target) {
        double left = target - 0.5, right = target + 0.5;
        int l = bs(nums, left), r = bs(nums, right);
        if(l == r) return new int[]{-1, -1};
        return new int[]{l, r-1};
    }

    public int bs(int[] nums, double target) {
        int l = 0, h = nums.length-1;
        while(l <= h){
            int m = l + (h - l)/2;
            if(target > nums[m]) l = m+1;
            else h = m-1;
        }
        return l;
    }
}
