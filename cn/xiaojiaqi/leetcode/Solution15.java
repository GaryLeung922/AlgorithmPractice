package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution15 {
//    public static List<List<Integer>> threeSum(int[] nums) {
//    	List<List<Integer>> resList = new ArrayList<List<Integer>>();
//        HashSet<String> set = new HashSet<>();
//        if(nums!=null&&nums.length>2){
//            for(int i=0;i<nums.length;i++){
//                for(int j=i+1;j<nums.length;j++){
//                    int target = -(nums[i]+nums[j]);
//                    for(int k=j+1;k<nums.length;k++){
//                        
//                        if(nums[k]==target){
//                            int[] triplet = {nums[i],nums[j],nums[k]};
//                            Arrays.sort(triplet);
//                            String triStr = Arrays.toString(triplet);
//                            if(!set.contains(triStr)){
//                                set.add(triStr);
//                                resList.add((Arrays.asList(triplet[0],triplet[1],triplet[2])) );
//                            }
//                        } 
//                    }
//                }
//            }
//        }
//        return resList;
//    }
//	public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> resList = new ArrayList<List<Integer>>();
//        HashSet<String> set = new HashSet<>();
//        if(nums!=null&&nums.length>2){
//            for(int i=0;i<nums.length;i++){
//                List<List<Integer>> partList = twoSum(nums,i,-nums[i]);
//                for(List<Integer> li:partList){
//                    Collections.sort(li);
//                    if(!set.contains(li.toString())){
//                        resList.add(li);
//                    }else{
//                        set.add(li.toString());
//                    }
//                }
//            }
//            
//        }
//        return resList;
//    }
//    public static List<List<Integer>> twoSum(int[] arr,int i,int target){
//        List<List<Integer>> resList = new ArrayList<List<Integer>>();
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int j=i+1;j<arr.length;j++){
//            if(map.containsKey(target-arr[j])){
//                resList.add(Arrays.asList(-target,arr[j],target-arr[j]));
//            }
//            map.put(arr[j],j);
//        }
//        return resList;
//    }
	
	public static List<List<Integer>> threeSum(int[] arr) {
		List<List<Integer>> resList = new ArrayList<List<Integer>>();
		HashSet<String> set = new HashSet<>();
		if(arr!=null&&arr.length>2){
			process(arr, 3, 0, 0, new ArrayList<Integer>(), resList,set);
		}
		return resList;
	}
	public static void process(int[] arr,int nums,int start,int target,List<Integer> pre,List<List<Integer>> resList,HashSet<String> set){
		
		if(nums==1) {
			for(int i=start;i<arr.length;i++) {
				if(arr[i]==target) {
					pre.add(target);
					List<Integer> res = new ArrayList<>(3);
					for(Integer j:pre) {
						res.add(j);
					}
					Collections.sort(res);
					if(!set.contains(res.toString())) {
						resList.add(res);
						set.add(res.toString());
					}
					pre.remove(pre.size()-1);
					return ;
				}
			}
			return ;
		}else {
			
			for(int i=start;i<arr.length;i++) {
				pre.add(arr[i]);
				process(arr, nums-1, i+1, target-arr[i], pre,resList,set);
				pre.remove(pre.size()-1);
			}
		}
	}
    public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		List<List<Integer>> resList = threeSum(nums);
		HashMap<Integer, String> map = new HashMap<>();
		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1,4,2,6,3));
		System.out.println(al);
		Collections.sort(al);
		System.out.println(al.toString());
		
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		Integer[] res = new Integer[list.size()];
		list.toArray(res);
		for(int i:list) {
			
		}
		
		
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("dff1");
		list2.add("dff2");
		list2.add("dff3");
		list2.add("dff4");
		list2.add("dff5");
		String[] array = new String[list2.size()];
		String[] s=list2.toArray(array);
		
	}
}
