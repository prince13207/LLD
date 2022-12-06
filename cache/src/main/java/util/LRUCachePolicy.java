package main.java.util;

import java.util.HashMap;

public class LRUCachePolicy implements CachePolicy {
    HashMap<String, ListNode> data;
    DLL nodeList;

    public LRUCachePolicy() {
        data = new HashMap<>();
        nodeList = new DLL(new ListNode("/", "/"), new ListNode("/", "/"));
    }

    public void touch(String key, String... value) {
        ListNode node = data.get(key);
        if (value.length!=0) {
            if (node == null) {
                node = new ListNode(key, value[0]);
                nodeList.appendNode(node);
            } else {
                node.value = value[0];
                moveToEnd(node);
            }
        }
        data.put(key, node);

    }

    private void moveToEnd(ListNode node) {
        this.nodeList.removeNode(node);
        this.nodeList.appendNode(node);
    }

    @Override
    public String evict() {
        ListNode node = this.nodeList.removeNode(nodeList.head.next);
        data.remove(node.key);
        return node.key;
    }

    public ListNode firstNode() {
        return this.nodeList.head.next;
    }

    public ListNode lastNode() {
        return this.nodeList.tail.prev;
    }

    public class ListNode {
        String key;
        String value;
        ListNode next;
        ListNode prev;

        public ListNode(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }


    }

    class DLL {
        ListNode head;
        ListNode tail;

        public DLL(ListNode head, ListNode tail) {
            this.head = head;
            this.tail = tail;
            tail.prev = head;
            head.next = tail;
        }

        ListNode removeNode(ListNode node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            return node;
        }

        void appendNode(ListNode node) {
            tail.prev.next = node;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;
        }


    }
}
