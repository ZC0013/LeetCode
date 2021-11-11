import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Created by zhang on 2021/11/11  13:52
 */
public class LC297_二叉树的序列化与反序列化 {

    String NULL = "#";
    String COM = ",";
    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;
        String serialize = serialize2(null);
        TreeNode deserialize = deserialize2(serialize);
        System.out.println(deserialize);

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        serializeDfs(root,sb);
        return sb.toString();
    }

    public void serializeDfs(TreeNode root, StringBuffer sb){
        if( root == null ){
            sb.append(NULL).append(COM);
            return;
        }
        sb.append(root.val).append(COM);
        serializeDfs(root.left, sb);
        serializeDfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        for( String str : data.split(COM)){
            list.addLast(str);
        }
        return deserializeDfs( list );
    }

    public TreeNode deserializeDfs(LinkedList<String> list) {
        if( list.isEmpty() ){
            return null;
        }

        String temp = list.removeFirst();
        if( temp.equals(NULL) ) return null;
        TreeNode root = new TreeNode( Integer.parseInt(temp));
        root.left = deserializeDfs(list);
        root.right = deserializeDfs(list);
        return root;
    }

    /*   层序遍历  */
    public String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while( !queue.isEmpty() ){
            TreeNode node = queue.remove();
            if( node == null ){
                sb.append(NULL).append(COM);
                continue;
            }
            sb.append(node.val).append(COM);
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        Queue<TreeNode> q = new LinkedList<>();
        String[] nodes = data.split(COM);
        if( nodes[0].equals(NULL) ) return null;
        TreeNode root = new TreeNode( Integer.parseInt(nodes[0]));
        q.offer( root );
        for( int i = 1; i < nodes.length; ){
            TreeNode parent = q.poll();

            String left = nodes[i++];
            if( !left.equals(NULL) ){
                parent.left = new TreeNode( Integer.parseInt(left));
                q.offer(parent.left);
            }else{
                parent.left = null;
            }
            String right = nodes[i++];
            if( !right.equals(NULL) ){
                parent.right = new TreeNode( Integer.parseInt(right));
                q.offer(parent.right);
            }else{
                parent.right = null;
            }
        }
        return root;
    }
}
