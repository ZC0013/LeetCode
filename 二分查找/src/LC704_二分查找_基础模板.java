import org.junit.Test;

/**
 * @Created by zhang on 2021/11/13  10:16
 */
public class LC704_二分查找_基础模板 {



    @Test
    public void test(){
        int binarySearch = binarySearch(new int[]{5,7,7,8,8,10}, 6);
        System.out.println(binarySearch);
    }

    // 基础模板-1 左闭右闭区间 [left, right]
    // 算法缺陷，无法处理 nums = [1,2,2,2,3]，target 为 2时的左边界
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 因为为[left, right] 边界可以取到，所以应防止角标越界

        // 循环中止条件为 left == right + 1
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }

    /*
    二分查找的进阶版：左闭右开区间 [ left, right );
    在nums = [5,7,7,8,8,10], target = 8 中，寻找左边边界
    其实寻找的是第一个大于等于 target 的位置
     */
    public int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意
        // 方法思想为 不断的压缩右边界 right
        // 循环的退出条件 left == right
        while (left < right) { // 注意
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
        /* 如果要特定的寻找左边边界时，需要加上判断条件
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
         */
    }
    /*
    二分查找的进阶版：左闭右开区间 [ left, right );
    在nums = [5,7,7,8,8,10], target = 8 中，寻找右边边界
    其实寻找的是第一个大于等于 target 的位置
     */
    public int right_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            // 方法思想为 不断的压缩左边界 right
            // 循环的退出条件 left == right
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1; // 注意
    }
}
