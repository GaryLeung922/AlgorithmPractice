package cn.xiaojiaqi.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache {
    List<Integer> cache = new LinkedList<>();
    Map<Integer,Integer> map = new HashMap<>();
    int size = 0;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            cache.remove((Integer)key);
            cache.add(0,key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
        	cache.remove((Integer)key);
            cache.add(0,key);
            map.put(key,value);
        }else{
            if(size<capacity){
                map.put(key,value);
                cache.add(0,key);
                size++;
            }else{
                int delkey = cache.get(cache.size()-1);
                cache.remove((Integer) delkey);
                cache.add(0,key);
                map.put(key,value);
                map.remove(delkey);
            }
        }
    }
}
