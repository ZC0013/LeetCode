import java.util.*;
/**
 * @Created by zhang on 2021/11/10  23:30
 */
public class LC652_寻找重复的子树 {

    /*
    题目：给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
    对于本题，
    1. 首先需要知道自己的子树的情况(于是选择使用后序遍历，并使用字符串的方式序列化二叉树)
    2. 自己的子树是否与其他的子树相互重复，则使用 HashMap 存储 每个节点的子树 和 这个子树出现的次数 ( 用于保证重复的子树只添加一次)
     */
    HashMap<String, Integer> map;
    List<TreeNode> res;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        res = new LinkedList<>();
        dfs(root);
        return res;
    }

    public String dfs(TreeNode root){
        if( root == null ) return "#";

        String left = dfs(root.left);
        String right = dfs(root.right);

        String subString = left + "," + right + "," + root.val;
        int count = map.getOrDefault(subString,0);
        if( count == 1){
            res.add( root );
        }
        map.put(subString, count+1);
        return subString;
    }
}
