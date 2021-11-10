import org.junit.Test;

/**
 * @Created by zhang on 2021/11/10  20:20
 */
public class LC654_最大二叉树 {

    @Test
    public void test(){
        TreeNode node = constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println(node);
    }


    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs( int[] nums, int l, int r){
        if( l > r){
            return null;
        }
        int[] max = max(nums, l, r);
        int maxNum = max[0];
        int maxInd = max[1];
        TreeNode root = new TreeNode( maxNum );
        root.left = dfs( nums, l, maxInd - 1);
        root.right = dfs( nums, maxInd + 1, r );
        return root;
    }

    public int[] max(int[] nums, int l, int r){
        int[] res = new int[2];
        res[0] = nums[l];
        res[1] = l;
        for( int i = l + 1 ; i <= r; i++ ){
            if( nums[i] > res[0] ){
                res[0] = nums[i];
                res[1] = i;
            }
        }
        return res;
    }
}
