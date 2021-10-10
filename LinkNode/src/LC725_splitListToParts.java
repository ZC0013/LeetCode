import org.junit.Test;

import java.util.Arrays;

/**
 * @Created by zhang on 2021/9/22  20:13
 */
public class LC725_splitListToParts {

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

        ListNode[] listNodes = template(head, 3);
        System.out.println(Arrays.toString(listNodes));
    }

    /*
    典型的均分链表题目：
    两遍循环，第一遍循环得到整个链表的个数；
    第二遍循环：开始均分链表
     */
    public ListNode[] template(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        int quotient = n / k, remainder = n % k;

        ListNode[] parts = new ListNode[k];
        ListNode curr = head;
        for(int i = 0; i < k && curr != null; i++){
            int partSize = quotient + (i < remainder ? 1 : 0);
            parts[i] = curr;
            for (int j = 1; j < partSize; j++){
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return parts;
    }


    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        if(head == null) return res;

        int count = 1;
        ListNode temp = head;
        while(temp.next != null){
            count++;
            temp = temp.next;
        }
        temp = head;
        if(count <= k){
            for(int i = 0; i < count; i++){
                ListNode add1 = new ListNode(temp.val);
                res[i] = add1;
                temp = temp.next;
            }
        }else{
            int c = count % k;
            int[] counts = new int[k];
            Arrays.fill(counts, count / k);
            int cc = 0;
            while(c-- > 0){
                counts[cc++] += 1;
            }
            int index = 0;
            ListNode lastHead;
            ListNode nextHead = head;
            while(nextHead != null){
                lastHead = nextHead;
                res[index] = nextHead;
                for(int i = 1; i < counts[index]; i++){
                    nextHead = nextHead.next;
                    lastHead = lastHead.next;
                }
                nextHead = nextHead.next;
                lastHead.next = null;
                index++;
            }
        }
        return res;
    }


}
