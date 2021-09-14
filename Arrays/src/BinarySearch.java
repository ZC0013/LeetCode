import org.junit.Test;

/**
 * @Created by zhang on 2021/9/6  21:09
 */
public class BinarySearch {

    @Test
    public void BinarySearch(){
        int[] nums = {-1};
        int res = method1(nums, -1);
        System.out.println(res);
    }

    public int method1(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;

        while( l <= r ){
            int mid = ( l + r ) >>> 1;
            if( nums[mid] < target){
                l = mid + 1;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
