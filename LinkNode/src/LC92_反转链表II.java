import org.junit.Test;

/**
 * @Created by zhang on 2021/10/29  16:12
 */
public class LC92_反转链表II {


    @Test
    public void test(){
        ListNode head = new ListNode(1);
        ListNode Node1 = new ListNode(2);
//        ListNode Node2 = new ListNode(3);
//        ListNode Node3 = new ListNode(4);
//        ListNode Node4 = new ListNode(5);
        head.next = Node1;
//        Node1.next = Node2;
//        Node2.next = Node3;
//        Node3.next = Node4;
        ListNode listNode = reverseBetween(head, 1, 2);
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            // 将 next 保存
            next = cur.next;
            // 将 next 从 head 中删除
            cur.next = next.next;
            // 将 next 加在 pre 和 cur 之间 ( 以下两步 )
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }


}
