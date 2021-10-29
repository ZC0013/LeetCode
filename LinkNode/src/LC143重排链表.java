import org.junit.Test;



/**
 * @Created by zhang on 2021/10/29  17:57
 */
public class LC143重排链表 {

    @Test
    public void test(){
        ListNode head = new ListNode(1);
        ListNode Node1 = new ListNode(2);
        ListNode Node2 = new ListNode(3);
        ListNode Node3 = new ListNode(4);
//        ListNode Node4 = new ListNode(5);
        head.next = Node1;
        Node1.next = Node2;
        Node2.next = Node3;
//        Node3.next = Node4;
        reorderList(head);
    }

    public void reorderList(ListNode head) {
        if( head == null || head.next == null ) return;
        ListNode low = head;
        ListNode fast = head;
        while( fast != null && fast.next != null){
            low = low.next;
            fast = fast.next.next;
        }
        ListNode reverse = reverse(low.next);
        low.next = null;
        ListNode add = head;
        ListNode t1;
        ListNode t2;
        while ( reverse != null ){
            t2 = add.next;
            t1 = reverse.next;
            add.next = reverse;
            reverse.next = t2;
            add = t2;
            reverse = t1;
        }

    }

    public ListNode reverse(ListNode head){
        if( head == null || head.next == null ) return head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode temp;
        while( cur != null ){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
