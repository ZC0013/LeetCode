import org.junit.Test;

/**
 * @author zhangchuang
 * @create 2021-06-21 8:25 下午
 */
public class LeetCode203_RemoveLinkedListElements {

    @Test
    public void test(){
        ListNode head = new ListNode(7);
        ListNode Node1 = new ListNode(7);
        ListNode Node2 = new ListNode(7);
        ListNode Node3 = new ListNode(7);
        head.next = Node1;
        Node1.next = Node2;
        Node2.next = Node3;
        ListNode listNode = removeElements(head, 7);
        System.out.println(listNode);
    }

    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode temp = head;
        ListNode pre;
        if(temp.next != null){
            pre = temp.next;
        }else if( temp.val == val){
            return null;
        }else{
            return head;
        }

        while(pre != null){
            if(pre.val == val){
                temp.next = pre.next;
            }else{
                temp = temp.next;
            }
            pre = temp.next;
        }
        if(head.val == val) return head.next;
        return head;
    }
}
