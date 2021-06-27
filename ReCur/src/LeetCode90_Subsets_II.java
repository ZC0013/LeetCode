import org.junit.Test;

import java.util.*;

/**
 * @author zhangchuang
 * @create 2021-06-17 9:28 下午
 */
public class LeetCode90_Subsets_II {

    @Test
    public void test(){

        int[] nums = {1,2,2,3};
        List<List<Integer>> lists = subsetsWithDup(nums);
        System.out.println(lists);

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();

        dfs(nums,res, numList, 0);

        return res;
    }

    private void dfs(int[] nums,List<List<Integer>> res,List<Integer> numList,int k){

        res.add(new ArrayList(numList));

        Map<Integer,Boolean> visited = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            visited.put(nums[i], false);
        }

        for (int i = k; i < nums.length; i++) {
            if(!visited.get(nums[i])){
                numList.add(nums[i]);
                dfs(nums, res, numList,i+1);
                numList.remove(numList.size()-1);
                visited.put(nums[i], true);
            }
        }

    }

}
