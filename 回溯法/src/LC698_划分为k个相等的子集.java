import java.util.Arrays;
import java.util.Comparator;

/**
 * @Created by zhang on 2021/11/12  10:50
 */
public class LC698_划分为k个相等的子集 {


    /*
    方法一：以每个桶为基础
    对于某个桶不满足时即可提前退出循环，故时间消耗小
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if( k > nums.length ) return false;
        int sum = 0;
        for( int num : nums ){
            sum += num;
        }
        if( sum % k != 0) return false;
        int target = sum / k;
        boolean[] used = new boolean[nums.length];
        return backtrack(k, 0, nums, 0, target, used);
    }

    public boolean backtrack(int k, int buttle, int[] nums, int start, int target, boolean[] used){
        if( k == 0 ){
            return true;
        }
        if( buttle == target ){
            return backtrack(k-1, 0, nums, 0, target, used);
        }
        for (int i = start; i < nums.length; i++) {
            if( used[i] ){
                continue;
            }
            if( buttle + nums[i] > target){
                continue;
            }
            used[i] = true;
            buttle += nums[i];
            if(backtrack(k, buttle, nums, i+1, target, used)){
                return true;
            }
            used[i] = false;
            buttle -= nums[i];
        }
        return false;
    }
    /*
    方法二：以每个数字为基础
     */
    public boolean canPartitionKSubsets2(int[] nums, int k) {
        Integer[] newNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(newNums,new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b-a;
            }
        });
        nums =Arrays.stream(newNums).mapToInt(Integer::valueOf).toArray();
        int n = nums.length;
        if( k > n ) return false;
        int sum = 0;
        for( int num : nums){
            sum += num;
        }
        if( sum % k != 0 ) return false;
        int[] buttle = new int[k];
        int target = sum / k;
        return dfs( nums, buttle, 0, target);
    }

    public boolean dfs(int[] nums, int[] buttle, int index, int target){
        if( index == nums.length ){
            for( int i = 0; i < buttle.length; i++){
                if( buttle[i] != target ){
                    return false;
                }
            }
            return true;
        }

        for( int i = 0; i < buttle.length; i++){
            if( nums[index] + buttle[i] > target ){
                continue;
            }
            buttle[i] += nums[index];
            if( dfs( nums, buttle, index+1, target ) ){
                return true;
            }
            buttle[i] -= nums[index];
        }
        return false;
    }
}
