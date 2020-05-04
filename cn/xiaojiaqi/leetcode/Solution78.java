package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {
	static List<List<Integer>> lists = new ArrayList<List<Integer>>();
    public static List<List<Integer>> subsets(int[] nums) {
        if(nums==null||nums.length==0){
            List<Integer> list = new ArrayList<>();
            lists.add(list);
            return lists;
        }
        
        p(nums,0,new ArrayList<>());
        return lists;
    }
    public static void p(int[] nums,int i,List<Integer> list){
        if(i>=nums.length){
        	List<Integer> copyList = new ArrayList<>();
        	copyList.addAll(list);
            lists.add(copyList);
            return ;
        }
        list.add(nums[i]);
        p(nums,i+1,list);
        list.remove(list.size()-1);
        p(nums,i+1,list);
    }
    public static void main(String[] args) {
		int[] nums = {1,2,3};
		subsets(nums);
		
	}
}