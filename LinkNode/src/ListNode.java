/**
 * @author zhangchuang
 * @create 2021-06-21 8:26 下午
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;}

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
