package cn.xiaojiaqi.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/20 3:35 PM
 */
public class LeetCode_LRUCache_02 {
    static class LRUCache {
        Map<Integer, Node> map = new HashMap<>();
        DoubleList list = new DoubleList();
        int size = 0;
        public LRUCache(int capacity) {
            this.size = capacity;
        }

        public int get(int key) {
            int res = -1;
            if(map.containsKey(key)){
                Node node = map.get(key);
                list.move2head(map.get(key));
                res = node.value;
            }
            return res;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)){
                Node node = map.get(key);
                node.value = value;
                list.move2head(node);
            }else{
                Node node = new Node(key, value);
                map.put(key, node);
                list.insert(node);
                if(list.size>this.size){
                    map.remove(list.remove());
                }
            }
        }

        class DoubleList{
            private Node head, tail;
            private int size;

            public DoubleList() {
                head = new Node();
                tail = new Node();
                head.next = tail;
                tail.prev = head;
                this.size = 0;
            }

            public void insert(Node node){
                node.next = head.next;
                head.next.prev = node;
                node.prev = head;
                head.next = node;
                this.size++;
            }
            public int remove(Node node){
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.next = null;
                node.prev = null;
                this.size--;
                return node.key;
            }
            public int remove(){
                if(this.size>0){
                   return remove(this.tail.prev);
                }
                return -1;
            }
            public void move2head(Node node){
                remove(node);
                insert(node);
            }
        }
        class Node{
            public int key;
            public int value;
            public Node next;
            public Node prev;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public Node() {
            }
        }
    }

    public static void main(String[] args) {
        LeetCode_LRUCache_02 s  =new LeetCode_LRUCache_02();
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }
}
