import org.junit.Test;

import java.util.Arrays;

public class LC581_Shortest_Unsorted_Continuous_Subarray {

    @Test
    public void findUnsortedSubarray() {

        int[] nums = new int[]{1,2,4,3,6,7,10,9,8};
        int twoPoint = twoPoint(nums);
        System.out.println(twoPoint);
    }

    /**
     * 方法一：排序比较
     *
     * @param nums 待比较的数组参数
     * @return 边界值查
     */
    public int arraycopy(int[] nums) {
        int[] sorted_nums = new int[nums.length];
        System.arraycopy(nums, 0, sorted_nums, 0, nums.length);
        // 对数组的副本排序，得到升序数组
        Arrays.sort(sorted_nums);
        int n = nums.length;

        // 双指针分别找到不同段落的边界
        int l = -1, r = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != sorted_nums[i]) {
                l = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] != sorted_nums[i]) {
                r = i;
                break;
            }
        }

        if (l == -1) return 0;
        return r - l + 1;
    }


    /**
     * 方法二：一次遍历
     */
    public int twoPoint(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }


}
