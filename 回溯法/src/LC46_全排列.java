import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Created by zhang on 2021/11/11  23:12
 */
public class LC46_全排列 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtrack( nums, res, path, used );
        return res;
    }

    public void backtrack(int[] nums, List<List<Integer>> res, LinkedList<Integer> path, boolean[] used){
        if( path.size() == nums.length ){
            res.add( new ArrayList(path));
            return;
        }

        for( int i = 0; i < nums.length; i++){
            if( used[i] ){
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);
            backtrack( nums, res, path, used );
            used[i] = false;
            path.removeLast();
        }

    }
}
