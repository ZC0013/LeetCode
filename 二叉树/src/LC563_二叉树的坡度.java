import org.junit.Test;

/**
 * @Created by zhang on 2021/11/20  0:15
 */
public class LC563_二叉树的坡度 {

    @Test
    public void test(){
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
//        node3.left = node6;
        node3.right = node6;
        int res = findTilt(root);
        System.out.println(res);
    }

    int res = 0;
    public int findTilt(TreeNode root) {
        dfs( root);
        return res;
    }

    public int dfs(TreeNode root){
        if( root == null ) return 0;
        int left = dfs( root.left );
        int right = dfs( root.right );
        res += Math.abs(left - right);
        return root.val + left + right;
    }
}
