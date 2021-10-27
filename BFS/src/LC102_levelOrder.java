import org.junit.Test;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LC102. 二叉树的层序遍历
 * 难度：中等
 * @author zhangchuang
 * @create 2021-10-15 9:19 下午
 */
public class LC102_levelOrder {

    /*
    最基本的 BFS 算法实现
    实现：队列 + 循环
     */


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLev1elSize = queue.size();
            for (int i = 1; i <= currentLev1elSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }
}
