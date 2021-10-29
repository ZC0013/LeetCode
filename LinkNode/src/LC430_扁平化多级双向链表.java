import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @Created by zhang on 2021/9/24  17:17
 */
public class LC430_扁平化多级双向链表 {

    @Test
    public void test(){

        Node1 head = new Node1(1);
        Node1 node1 = new Node1(2);
        Node1 node2 = new Node1(3);
        Node1 node3 = new Node1(4);
        Node1 node4 = new Node1(5);
        Node1 node5 = new Node1(6);

        head.child = node1;
        node1.child = node2;

        flattenPro(head);

    }

    /*
    官方题解：
    深度遍历
     */
    public Node1 flattenPro(Node1 head) {
        dfs(head);
        return head;
    }

    public Node1 dfs(Node1 node) {
        Node1 cur = node;
        // 记录链表的最后一个节点
        Node1 last = null;

        while (cur != null) {
            Node1 next = cur.next;
            //  如果有子节点，那么首先处理子节点
            if (cur.child != null) {
                Node1 childLast = dfs(cur.child);

                next = cur.next;
                //  将 node 与 child 相连
                cur.next = cur.child;
                cur.child.prev = cur;

                //  如果 next 不为空，就将 last 与 next 相连
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }

                // 将 child 置为空
                cur.child = null;
                last = childLast;
            } else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }

    /*
    使用一个栈，帮助存储需要添加的子节点。
     */
    public Node1 flatten(Node1 head) {
        LinkedList<Node1> addNode = new LinkedList();
        Node1 temp = head;
        if( head == null) return null;
        while( temp != null ){
            if( temp.child != null){
                addNode.add(temp.next);
                temp.next = temp.child;
                temp.next.prev = temp;
                temp.child = null;
            }
            temp = temp.next;
        }
        temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        while (!addNode.isEmpty()){
            Node1 node = addNode.pollLast();
            while (node != null) {
                temp.next = node;
                node.prev = temp;
                temp = temp.next;
                node = node.next;
            }
        }
        return head;
    }

}

