package leetcode.sword;

import leetcode.sword.helper.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 */
public class Test05 {

    Map<Node, Node> cachedNode = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }

    public Node copyRandomList2(Node head) {
       if(head == null) return null;
       Node cur = head;
       while(cur != null) {
           Node newNode = new Node(cur.val);
           newNode.next = cur.next;
           cur.next = newNode;
           cur = cur.next.next;
       }
       cur = head;
       while(cur != null) {
           if(cur.random != null) {
               cur.next.random = cur.random.next;
           }
           cur = cur.next.next;
       }
       cur = head.next;
       Node pre = head,res = head.next;
       while(cur.next != null) {
           pre.next = pre.next.next;
           cur.next = cur.next.next;
           pre = pre.next;
           cur = cur.next;
       }
       //设想如果只有两个节点 cur.next == null while循环进不去 此时需要将pre.next置为null 将两部分断开 链表很长同理pre的末端需要断开
       pre.next = null;
       return res;
    }


}
