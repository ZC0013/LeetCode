import java.util.*;
/**
 * @Created by zhang on 2021/11/10  22:49
 */
public class LC106_从中序与后序遍历序列构造二叉树 {

    public static void main(String[] args) {

        // 中序遍历
        int[] inorder = new int[]{9,3,15,20,7};
        // 后续遍历
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode node = buildTree(inorder, postorder);
        System.out.println(node);

    }

    static Map<Integer, Integer> dic;
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        dic = new HashMap<>();
        for( int i = 0; i < n; i++){
            dic.put( inorder[i], i);
        }
        return myBuild(postorder, inorder, 0, n-1, 0, n-1);
    }

    public static TreeNode myBuild(int[] postorder, int[] inorder, int postorder_left, int postorder_right, int inorder_left, int inorder_right){
        if( postorder_left > postorder_right) return null;
        int postorder_root = postorder[postorder_right];
        TreeNode root = new TreeNode( postorder_root );
        int inorder_root = dic.get(postorder_root);
        int sizeOfRight = inorder_right - inorder_root;
        root.left = myBuild(postorder, inorder, postorder_left, postorder_right-sizeOfRight-1, inorder_left, inorder_root-1);
        root.right = myBuild(postorder, inorder, postorder_right-sizeOfRight, postorder_right-1, inorder_root+1, inorder_right);
        return root;
    }
}
