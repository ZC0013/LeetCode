/**
 * @Created by zhang on 2021/10/29  19:46
 */
public class Node1 {
    int val;
    Node1 next;
    Node1 child;
    Node1 prev;


    public Node1(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
        this.child = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
