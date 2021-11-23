import org.junit.Test;

/**
 * @Created by zhang on 2021/11/22  16:25
 */
public class LC25_K个一组翻转链表 {


    @Test
    public void test(){

        ListNode head = new ListNode(1);
        ListNode Node1 = new ListNode(2);
        ListNode Node2 = new ListNode(3);
        ListNode Node3 = new ListNode(4);
        ListNode Node4 = new ListNode(5);
        head.next = Node1;
        Node1.next = Node2;
        Node2.next = Node3;
        Node3.next = Node4;

        ListNode listNode = reverseKGroup(head, 2);
        System.out.println(listNode);
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        // 哨兵节点
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp;
        while (pre != tail) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return new ListNode[]{tail, head};
    }
}
