import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Created by zhang on 2021/11/11  22:39
 */
public class LC78_子集 {

    @Test
    public void test(){
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new LinkedList<Integer>());
        return res;

    }

    private void backtrack(int start, int[] nums, List<List<Integer>> res, LinkedList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.addLast(nums[i]);
            backtrack(i + 1, nums, res, tmp);
            tmp.removeLast();
        }
    }


}
