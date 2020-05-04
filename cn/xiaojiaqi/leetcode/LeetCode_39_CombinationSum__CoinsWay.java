package cn.xiaojiaqi.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_39_CombinationSum__CoinsWay {
	static List<List<Integer>> result = new LinkedList<List<Integer>>();
	static List<Integer> cob = new LinkedList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null&&candidates.length==0)return null;
        combinationSum(candidates,0,target);
        return result;
    }
    public static void combinationSum(int[] candidates, int i,int res) {
        if(i<candidates.length){
            if(res==0){
                result.add(new LinkedList<>(cob));
            }else{
                int j = 0;
                for(;res-j*candidates[i]>=0;j++){
                    if(j>0)cob.add(candidates[i]);
                    combinationSum(candidates,i+1,res-j*candidates[i]);
                }
                while(j>1){
                    cob.remove(cob.size()-1);
                    j--;
                }
            }
        }else{
            if(res==0)result.add(new LinkedList<>(cob));
        }
    }
    public static void main(String[] args) {
		int[] nums = {2,3,6,7};
		combinationSum(nums, 7);
	}
}