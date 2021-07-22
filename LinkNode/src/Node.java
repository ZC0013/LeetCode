/**
 * @author zhangchuang
 * @create 2021-07-22 10:13 上午
 */
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
