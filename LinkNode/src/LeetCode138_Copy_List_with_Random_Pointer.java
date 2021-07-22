import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangchuang
 * @create 2021-07-22 10:15 上午
 */
public class LeetCode138_Copy_List_with_Random_Pointer {

    @Test
    public void test(){
        Node head = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        head.random = null;
        node1.random = head;
        node2.random = node4;
        node3.random = node2;
        node4.random = head;

        Node resultNode = copyRandomList(head);
        System.out.println(resultNode);


    }

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node headCopy = new Node(head.val);
        Node temp = head;
        Node tempCopy = headCopy;
        while( temp.next != null){
            tempCopy.next = new Node(temp.next.val);
            temp = temp.next;
            tempCopy = tempCopy.next;
        }
        temp = head;
        tempCopy = headCopy;
        Node index = head;
        Node indexCopy = headCopy;

        while( temp != null){
            if(temp.random != null){
                indexCopy = headCopy;
                index = head;
                while(temp.random != index.random){
                    index = index.next;
                    indexCopy = indexCopy.next;
                }
                tempCopy.random = indexCopy;
            }
            temp = temp.next;
            tempCopy = tempCopy.next;
        }
        return headCopy;
    }

    public Node map(Node head){
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(-1);
        Node tail = dummy, tmp = head;
        while (tmp != null) {
            Node node = new Node(tmp.val);
            map.put(tmp, node);
            tail.next = node;
            tail = tail.next;
            tmp = tmp.next;
        }
        tail = dummy.next;
        while (head != null) {
            if (head.random != null) tail.random = map.get(head.random);
            tail = tail.next;
            head = head.next;
        }
        return dummy.next;
    }

}
