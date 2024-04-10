package leetcode.top.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: LRU_CACHE
 * @author: dingwei17@jd.com
 * @date : 2024/4/2 21:23
 */
public class LRUCache {

    private int size;

    private int capacity;

    private Map<Integer, DLinkedNode> cacheMap;

    private DLinkedNode head;

    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        cacheMap = new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cacheMap.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cacheMap.get(key);
        if (node == null) {
            if (++size > capacity) {
                DLinkedNode removeNode = removeTailNode();
                size--;
                if (removeNode != null) {
                    cacheMap.remove(removeNode.key);
                }
            }
            DLinkedNode newNode = new DLinkedNode(key, value);
            addToHead(newNode);
            cacheMap.put(key, newNode);
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    public void moveToHead(DLinkedNode node) {
        removeExistNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeExistNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DLinkedNode removeTailNode() {
        if (size > 0) {
            DLinkedNode node = tail.prev;
            removeExistNode(node);
            return node;
        }
        return null;
    }

    class DLinkedNode {

        DLinkedNode prev;

        DLinkedNode next;

        private int key;

        private int value;

        public DLinkedNode() {

        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

}
