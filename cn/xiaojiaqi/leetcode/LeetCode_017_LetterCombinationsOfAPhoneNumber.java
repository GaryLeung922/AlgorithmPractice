package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @Author: Gary Leung
 * @Date: 9/11/20 9:48 PM
 */
public class LeetCode_017_LetterCombinationsOfAPhoneNumber {
    /**
     * 回溯算法
     */
    static class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if(digits==null || digits.length()==0)return res;
            int[] nums = null;
            try{
                nums = init(digits);
            }catch (Exception e){
                return res;
            }
            Map<Integer, String> map = new HashMap<>(8);
            map.put(2,"abc");
            map.put(3,"def");
            map.put(4,"ghi");
            map.put(5,"jkl");
            map.put(6,"mno");
            map.put(7,"pqrs");
            map.put(8,"tuv");
            map.put(9,"wxyz");
            letterCombinations(0,nums,new char[nums.length], res,map);
            return res;
        }

        private void letterCombinations(int i, int[] nums, char[] track, List<String> res, Map<Integer, String> map){
            if(i==nums.length){
                res.add(new String(track));
                return;
            }
            String participant = map.get(nums[i]);
            for(int j=0;j<participant.length();j++){
                track[i] = participant.charAt(j);
                letterCombinations(i+1,nums,track,res,map);
            }

        }
        private int[] init(String digits){

            int[] res = new int[digits.length()];
            for(int i=0;i<digits.length();i++){
                int in = Integer.valueOf(digits.substring(i,i+1));
                res[i] = in;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String digits = "23";
        List<String> stringList = solution.letterCombinations(digits);
        System.out.println(stringList);
    }
}
