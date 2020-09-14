package cn.xiaojiaqi.leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @Author: Gary Leung
 * @Date: 9/14/20 9:36 PM
 */
public class LeetCode_460_LFUCache {
    /**
     * 时间复杂度不是O(1)
     */
    class LFUCache {

        Map<Integer, Node> map = new HashMap<>();
        DoubleList list = new DoubleList();
        int size;

        public LFUCache(int capacity) {
            this.size = capacity;
        }

        public int get(int key) {
            Node node = map.get(key);
            if(node==null){
                return -1;
            }
            node.times++;
            list.modify(node);
            return node.value;
        }

        public void put(int key, int value) {
            if(this.size==0)return;
            if(map.containsKey(key)){
                Node node = map.get(key);
                node.value = value;
                node.times++;
                list.modify(node);
            }else{
                Node node = new Node(key,value);
                map.put(key, node);
                if(list.size()>=this.size){
                    map.remove(list.removeLast());
                }
                list.insertTail(node);
                list.modify(node);
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

        public void insertHead(Node node){
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

        public void insertTail(Node node){
            if(size>0){
                tail.next = node;
                node.pre = tail;
                tail = node;
            }else{
                head = node;
                tail = node;
            }
            size++;
        }

        public void modify(Node node){
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
            Node pre = node.pre;
            node.pre = null;
            node.next = null;
            while (pre!=null && pre.times<=node.times){
                pre = pre.pre;
            }
            if(pre==null){
                size--;
                insertHead(node);
            }else {
                node.pre = pre;
                node.next = pre.next;
                if(pre.next!=null){
                    pre.next.pre = node;
                }
                pre.next = node;
                if(node.next==null){
                    tail = node;
                }
            }


        }


    }
    class Node {
        public int key;
        public int value;
        public int times = 1;
        public Node pre, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 参考解法
     */
    class LFUCache02 {
        HashMap<Integer, Integer> vals;   // k->v
        HashMap<Integer, Integer> counts;  // k->freq
        HashMap<Integer, LinkedHashSet<Integer>> lists;  // freq -> k
        int cap;
        int min = -1;

        public LFUCache02(int capacity) {
            cap = capacity;
            vals = new HashMap<>();
            counts = new HashMap<>();
            lists = new HashMap<>();
            lists.put(1, new LinkedHashSet<>());
        }

        public int get(int key) {
            if (!vals.containsKey(key))
                return -1;
            int count = counts.get(key);
            counts.put(key, count + 1);
            lists.get(count).remove(key);
            if (count == min && lists.get(count).size() == 0)
                min++;
            if (!lists.containsKey(count + 1))
                lists.put(count + 1, new LinkedHashSet<>());
            lists.get(count + 1).add(key);
            return vals.get(key);
        }

        public void set(int key, int value) {
            if (cap <= 0)
                return;
            if (vals.containsKey(key)) {
                vals.put(key, value);
                get(key);
                return;
            }
            if (vals.size() >= cap) {
                int evit = lists.get(min).iterator().next();
                lists.get(min).remove(evit);
                vals.remove(evit);
            }
            vals.put(key, value);
            counts.put(key, 1);
            min = 1;
            lists.get(1).add(key);
        }
    }



    /**
     * Your LFUCache object will be instantiated and called as such:
     * LFUCache obj = new LFUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    public static void main(String[] args) {
        LeetCode_460_LFUCache code_460_lfuCache = new LeetCode_460_LFUCache();
        code_460_lfuCache.main();
    }
    public void main(){
        LFUCache cache = new LFUCache( 0 /* capacity */ );

        cache.put(0,0);
        cache.get(0);
//        cache.put(2, 2);
//        cache.put(1, 1);
//        cache.get(2);       // returns 1
//        cache.get(1);       // returns 1
//        cache.get(2);       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        cache.put(4, 4);       // returns -1 (not found)
//        cache.get(3);       // returns 3.
//        cache.get(2);       // returns -1 (not found)
//        cache.get(1);       // returns 3
//        cache.get(4);       // returns 4
    }
}
