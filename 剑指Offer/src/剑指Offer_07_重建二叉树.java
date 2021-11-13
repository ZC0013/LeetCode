import org.junit.Test;

import java.util.HashMap;


/**
 * @Created by zhang on 2021/11/6  22:38
 */
public class 剑指Offer_07_重建二叉树 {

    @Test
    public void test(){
        TreeNode node = buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(node);
    }
    HashMap<Integer, Integer> dic;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if( n == 0 ) return null;
        dic = new HashMap<>();
        for (int i = 0; i < n; i++) {
            dic.put(inorder[i], i);
        }
        return recure( preorder, inorder, 0,n-1, 0, n-1);
    }
    public TreeNode recure(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right){
        if( preorder_left > preorder_right ){
            return null;
        }
        int preorder_root = preorder[preorder_left];
        int inorder_root = dic.get(preorder_root);
        int sizeOfLeft = inorder_root - inorder_left;
        TreeNode root = new TreeNode(preorder_root);
        root.left = recure( preorder, inorder, preorder_left + 1,preorder_left + sizeOfLeft, inorder_left, inorder_root);
        root.right = recure( preorder, inorder, preorder_left + sizeOfLeft + 1,preorder_right, inorder_root + 1, inorder_right);
        return root;
    }
}
