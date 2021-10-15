import org.junit.Test;

import java.util.Random;

/**
 * @author zhangchuang
 * @create 2021-10-13 7:48 下午
 */
public class LC215_K_Max {

    @Test
    public void test(){
        int[] arr = new int[]{3,2,1,5,6,4};
        int kthLargest = findKthLargest(arr, 2);
        System.out.println(kthLargest);

    }

    Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);

    }

    public int quickSort(int[] nums, int l, int r, int k){
        int part = partition(nums, l, r);
        if( part == nums.length - k ){
            return nums[part];
        }else{
            if( part < nums.length - k ){
                return quickSort(nums, part + 1, r, k);
            }else{
                return quickSort(nums, l, part - 1, k);
            }
        }
    }

    public int partition(int[] nums, int l, int r){
        int randomIndex = random.nextInt( r - l + 1) + l;
        swap(nums, randomIndex, l);
        int provit = nums[l];
        int lt = l;
        for( int i = l + 1; i <= r; i++){
            if( nums[i] < provit){
                lt++;
                swap(nums, lt, i);
            }
        }
        swap(nums, lt, l);
        return lt;
    }


    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
