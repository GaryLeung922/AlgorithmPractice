package cn.xiaojiaqi.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/14 8:27 AM
 */
public class LeetCode_146_LRUCache {
    class LRUCache {
        Map<Integer, Node> map = new HashMap<>();
        DoubleList list = new DoubleList();
        int size;

        public LRUCache(int capacity) {
            this.size = capacity;
        }

        public int get(int key) {
            Node node = map.get(key);
            if(node==null){
                return -1;
            }
            list.moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)){
                Node node = map.get(key);
                node.value = value;
                list.moveToHead(node);
            }else{
                Node node = new Node(key,value);
                map.put(key, node);
                list.insert(node);
                if(list.size()>this.size){
                    map.remove(list.removeLast());
                }
            }
        }
    }
    static class DoubleList{
        private Node head, tail;
        private int size;

        public DoubleList() {
        }
        public int size(){
            return this.size;
        }

        public int removeLast(){
            int remove = tail.key;
            if(size>1){
                tail = tail.pre;
                tail.next = null;
                size--;
            }else if(size==1){
                head = null;
                tail = null;
                size--;
            }
            return remove;
        }

        public void insert(Node node){
            if(size>0){
                node.next = head;
                head.pre = node;
                head = node;
            }else{
                head = node;
                tail = node;
            }
            size++;
        }

        public void moveToHead(Node node){
            if(node.pre!=null){
                node.pre.next = node.next;
            }else{
                head = node.next;
            }

            if(node.next!=null){
                node.next.pre = node.pre;
            }else{
                tail = node.pre;
            }
            node.next = null;
            node.pre = null;
            size--;
            insert(node);
        }


    }
    class Node {
        public int key;
        public int value;
        public Node pre, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LeetCode_146_LRUCache lruCache = new LeetCode_146_LRUCache();
        lruCache.main();
    }
    public void main(){
        LRUCache lRUCache = new LRUCache(1);
        lRUCache.put(2, 1);
        //lRUCache.put(2, 2);
        lRUCache.get(2);    // return 1
        lRUCache.put(3, 2); // evicts key 2
        lRUCache.get(2);    // returns -1 (not found)
//        lRUCache.put(4, 4); // evicts key 1
//        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
//        lRUCache.get(4);    // return 4
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
