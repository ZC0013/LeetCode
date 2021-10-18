import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Created by zhang on 2021/10/16  19:09
 */
public class LC144 {

    /*
    LC94二叉树的中序遍历
     */
    @Test
    public void test(){
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(2147483647);
        root.left = node1;
        root.right = node2;
        node1.right = node4;

        List<Integer> list = inorderTraversal(root);
        System.out.println(list);


    }

    /*
    中序遍历的迭代版本
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    /*
    检验是否为排序二叉树
     */
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode node, long l, long r){
        if( node == null ) return true;

        if( node.val <= l || node.val >= r){
            return false;
        }

        return dfs(node.left, l, node.val) && dfs( node.right, node.val, r);
    }
}
