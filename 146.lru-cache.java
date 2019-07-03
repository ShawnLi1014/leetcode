/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (25.74%)
 * Likes:    3076
 * Dislikes: 106
 * Total Accepted:    310.8K
 * Total Submissions: 1.2M
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * 
 * LRUCache cache = new LRUCache( 2 /* capacity / );
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 * 
 * 
 * 
 */
class LRUCache {
    private static class DLinkedNode {
        int key, val;
        DLinkedNode pre, post;

        DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity, count;
    DLinkedNode head, tail;
    Map<Integer, DLinkedNode> map;

    private void addNode(DLinkedNode curr) {
        curr.post = head.post;
        head.post.pre = curr;
        head.post = curr;
        curr.pre = head;
    }

    private void remove(DLinkedNode curr) {
        DLinkedNode pre = curr.pre;
        DLinkedNode post = curr.post;
        pre.post = post;
        post.pre = pre;
    }

    private void moveToHead(DLinkedNode curr) {
        remove(curr);
        addNode(curr);
    }

    private DLinkedNode popTail() {
        DLinkedNode tNode = tail.pre;
        tNode.pre.post = tail;
        tail.pre = tNode.pre;
        return tNode;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        map = new HashMap<>();

        head = new DLinkedNode(-1, -1);
        head.pre = null;
        tail = new DLinkedNode(-1, -1);
        tail.post = null;
        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode curr = map.get(key);
        if (curr == null)
            return -1;
        moveToHead(curr);
        return curr.val;
    }

    public void put(int key, int value) {
        DLinkedNode curr = map.get(key);
        if (curr == null) {// add new node
            DLinkedNode newNode = new DLinkedNode(key, value);
            addNode(newNode);
            map.put(key, newNode);
            count++;

            if (count > capacity) {
                DLinkedNode tail = popTail();
                map.remove(tail.key);
                count--;
            }
        } else {
            curr.val = value;
            moveToHead(curr);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

