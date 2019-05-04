package cn.xiaojiaqi.leetcode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class Solution128 {
	public static class Node{
		public int value;
		public Node father;
		public Node(int value) {
			this.value = value;
			father = this;
		}
		public Node(int value,Node father) {
			this.value = value;
			this.father = father;
		}
	}
	
    public static Map<Node, Integer> sizeMap = new HashMap<>();
    public static void UnionFindSet(Collection<Node> list) {
        sizeMap.clear();
        for(Node node : list) {
            node.father = node;
            sizeMap.put(node, 1);
        }
    }
    public static Node findFather(Node p) {
        Node father = p.father;
        if(father!=p) {
            father = findFather(father);
        }
        p.father = father;
        return father;
    }
    public static boolean isSameSet(Node p,Node q) {
        return findFather(p)==findFather(q);
    }
    public static void union(Node p,Node q) {
        if(isSameSet(p, q))return;
        int lenp = sizeMap.get(findFather(p));
        int lenq = sizeMap.get(findFather(q));

        if(lenp>lenq) {
            findFather(q).father = findFather(p);
            sizeMap.put(findFather(q), lenp+lenq);
        }else {
            findFather(p).father = findFather(q);
            sizeMap.put(findFather(p), lenp+lenq);
        }
    }
	
    public static int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        int longest = 0;
        Map<Integer,Node> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],new Node(nums[i]));
        }
        UnionFindSet(map.values());
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]+1)){
                union(map.get(nums[i]),map.get(nums[i]+1));
            }
            if(map.containsKey(nums[i]-1)){
                union(map.get(nums[i]),map.get(nums[i]-1));
            }
            longest = Math.max(longest,sizeMap.get(findFather(map.get(nums[i]))));
        }
        return longest;
    }
    public static void main(String[] args) {
		int[] nums = {1,0,-1};
		int ans = longestConsecutive(nums);
		System.out.println(ans);
	}
}