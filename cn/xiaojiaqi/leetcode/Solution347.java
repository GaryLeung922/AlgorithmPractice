package cn.xiaojiaqi.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;



public class Solution347 {
    public static List<Integer> topKFrequent(int[] nums, int k) {
    	List<Integer> list = new LinkedList<>();
        if(nums==null||nums.length==0||k<=0||k>nums.length)return list;
        
        Map<Integer, Integer> map = new HashMap<>();
       // Map<Integer, Integer> help = new TreeMap<>();
        PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				
				return o1.getValue()-o2.getValue();
			}
		});
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        Entry<Integer, Integer>[] entry = new Entry[map.size()];
        map.entrySet().toArray(entry);
        for(int i=0;i<entry.length;i++) {
        	if(pq.size()>=k) {//log(k) 保证heap的大小为k即可
        		if(entry[i].getValue()>pq.peek().getValue()) {
        			pq.poll();
        			pq.offer(entry[i]);
        		}
        	}else {
        		pq.offer(entry[i]);
			}
        }
        for(int i=0;i<k;i++) {
        	list.add(pq.poll().getKey());
        }
        return list;
    }
    public static void main(String[] args) {
		int[] nums = {3,0,1,0};
		int k = 1;
		List<Integer> list = topKFrequent(nums, k);
		System.out.println(list);
	}
}