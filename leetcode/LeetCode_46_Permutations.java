package cn.xiaojiaqi.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode_46_Permutations {
	static List<List<Integer>> result = new LinkedList<List<Integer>>();
	static List<Integer> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums==null||nums.length==0)return result;
        
        int[] hash = new int[nums.length];
        permute(nums,res,hash);
        return result;
    }
    public void permute(int[] nums,List<Integer> res,int[] hash){
        if(res.size()==nums.length) {
            result.add(new LinkedList<Integer>(res));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(hash[i]==0){
                hash[i]=1;
                res.add(nums[i]);
                permute(nums,res,hash);
                hash[i]=0;
                res.remove(res.size()-1);
            }
        }
    }
    public static List<List<Integer>> permute2(int[] nums) {
        if(nums==null||nums.length==0)return result;
        
        p(nums,0);
        return result;
    }
    public static void p(int[] nums,int i){
        if(nums.length-1==i){
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
        for(int j=i;j<nums.length;j++){
            swap(nums,i,j);
            p(nums,i+1);
            swap(nums,i,j);
        }
    }
    public static void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String[] args) {
		int[] nums = {1,2,3};
		permute2(nums);
		System.out.println(result);
	}
    
}