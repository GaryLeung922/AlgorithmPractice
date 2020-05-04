package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode_621_Task_Scheduler {
	public static class Node{
		public char ch;
		public int nums;
		public Node(char ch,int nums) {
			this.ch = ch;
			this.nums = nums;
		}
	}
	//my solution
    public static int leastInterval1(char[] tasks, int n) {
    	if(n==0)return tasks.length;
        int[] nums = new int[26];
        int numsMax = 0;
        int maxIndex = 0;
        for(int i=0;i<tasks.length;i++){
            nums[tasks[i]-'A']++;
            if(numsMax<nums[tasks[i]-'A']){
                numsMax = nums[tasks[i]-'A'];
                maxIndex = tasks[i]-'A';
            } 
        }
        PriorityQueue<Node> heap = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				
				return o1.nums==o2.nums ? o1.ch-o2.ch : o2.nums-o1.nums;
			}
		});
        
        for(int i=0;i<nums.length;i++) {
        	if(nums[i]>0)heap.add(new Node((char) ('A'+i), nums[i]));
        }
        StringBuilder scheduler = new StringBuilder();
        while(!heap.isEmpty()) {
        	int interval = n;
        	List<Node> list = new ArrayList<>();
        	while(interval>=0&&!heap.isEmpty()) {
        		Node cur = heap.poll();
        		char ch = cur.ch;
        		if(scheduler.length()<=n) {
            		while(scheduler.lastIndexOf(ch+"")!=-1&&scheduler.length()<=n) {
            			scheduler.append("*");
            		}
            	}else {
            		while(scheduler.lastIndexOf(ch+"")>=scheduler.length()-n) {
                		scheduler.append("*");
                	}
            	}
                scheduler.append(ch);
                cur.nums--;
                interval--;
                if(cur.nums>0)list.add(cur);
        	}
        	for(Node node : list) {
        		heap.add(node);
        	}
        	list.clear();
        }
        
        return scheduler.length();
        
    }
    
  //Solution 1
    public static int leastInterval2(char[] tasks, int n) {
        if(n==0)return tasks.length;
        
        int[] map = new int[26];
        for(char c : tasks){
            map[c-'A']++;
        }
        Arrays.sort(map);
        int time = 0;
        while(map[25]>0){
            int interval = 0;
            while(interval<=n){
                if(map[25]<=0)break;//其它位置的个数最多有一个。这些位置就是刚开始的个数最大值
                if(interval<26&&map[25-interval]>0)map[25-interval]--;
                interval++;
                time++;    
            }
            
            Arrays.sort(map);
        }
        return time;
    }
    //solution2
    public static int leastInterval3(char[] tasks, int n) {
        if(n==0)return tasks.length;
        int[] map = new int[26];
        for(char c : tasks){
             map[c-'A']++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> temp = new ArrayList<>();
        for(int i : map){
            if(i>0)queue.add(i);
        }
        int time=0;
        while(!queue.isEmpty()){
            int i=0;
            while(i<=n){
                if(!queue.isEmpty()) {
	                if(queue.peek()>1){
	                    temp.add(queue.poll()-1);
	                }else{
	                    queue.poll();
	                }
                }
                time++;
                if(queue.isEmpty()&&temp.size()==0)break;
                i++;
                
            }
            
            for(int j : temp){
                queue.add(j);
            }
            temp.clear();
        }
        return time;
    }
    //推荐
    //花花酱 return (k-1)*(n+1)+p >= tasks ? (k-1)*(n+1)+p : tasks;
    // k:最大个数 ; p:拥有相同k的任务种类
    public static int leastInterval4(char[] tasks, int n) {
        int[] map = new int[26];
        int maxNums = 0;
        for(char c : tasks){
            map[c-'A']++;
            maxNums = Math.max(maxNums,map[c-'A']);
        }
        int maxCount = 0;
        for(int i : map){
            if(i==maxNums)maxCount++;
        }
        int ans =  (maxNums-1)*(n+1)+maxCount;
        return ans>tasks.length ? ans : tasks.length;
    }
    public static void main(String[] args) {
		String[] taskstr = {"A","A","A","B","B","B"};
		char[] tasks = new char[taskstr.length];
		for(int i=0;i<taskstr.length;i++) {
			tasks[i] = taskstr[i].charAt(0);
		}
		int n = 2;
		int res = leastInterval3(tasks, n);
		System.out.println(res);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	}
}