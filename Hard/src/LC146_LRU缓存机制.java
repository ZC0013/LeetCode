import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created by zhang on 2021/10/18  22:55
 */
public class LC146_LRU缓存机制 {

    /*
    LC146 LRU 缓存机制 Least Recently Used
    实现最近最少使用的缓存机制
    使用 哈希表 + 双向链表 实现，类似于 java 中的LinkedHashMap
    双向链表：使用双向链表来存储键值对，靠近头部的是最近使用的，靠近尾部的是最久未被使用的；
        尾部和头部增加删除节点的复杂度也为 O(1)
        *** 在双向链表的实现中增加了 head 和 tail 的伪头部和伪尾部，避免检测相邻节点的存在性
    哈希表：通过哈希表，缓存数据的键值对在链表中的位置   访问速度为 O(1)

     */
    @Test
    public void test(){
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4

    }


}

class LRUCache {
    // 双向链表
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {

        }
        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    // 哈希表 ：缓存数据的键值对在链表中的位置
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;       // 当前 LRU 缓存的节点数
    private int capacity;   // LRU 缓存的初始容量
    // 添加伪头部和伪尾部，避免检测相邻节点的存在性
    private DLinkedNode head, tail;

    // 初始化 LRU缓存
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    // 如果关键字 key 存在于缓存中，则返回关键字的值(并将其移动到头部)，否则返回 -1
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }
    // 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
    // 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    // 移动到头部，可以转化成 删除当前节点，然后再把当前节点添加到头部
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}

