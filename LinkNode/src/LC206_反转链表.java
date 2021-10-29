import org.junit.Test;

/**
 * @Created by zhang on 2021/10/29  11:27
 */
public class LC206_反转链表 {

    @Test
    public void test(){
        ListNode head = new ListNode(1);
        ListNode Node1 = new ListNode(2);
        ListNode Node2 = new ListNode(3);
        ListNode Node3 = new ListNode(4);
        ListNode Node4 = new ListNode(5);
        ListNode Node5 = new ListNode(6);
        ListNode Node6 = new ListNode(7);
        ListNode Node7 = new ListNode(8);
        ListNode Node8 = new ListNode(9);
        ListNode Node9 = new ListNode(10);
        head.next = Node1;
        Node1.next = Node2;
        Node2.next = Node3;
        Node3.next = Node4;
        Node4.next = Node5;
        Node5.next = Node6;
        Node6.next = Node7;
        Node7.next = Node8;
        Node8.next = Node9;
        ListNode listNode = reverseList(head);
        System.out.println(listNode);

    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp;
        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
