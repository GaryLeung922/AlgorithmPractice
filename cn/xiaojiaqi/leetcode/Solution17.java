package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution17 {
    public static List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0)return null;
        HashMap<Character,String> digitMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        digitMap.put('2',"abc");
        digitMap.put('3',"def");
        digitMap.put('4',"ghi");
        digitMap.put('5',"jkl");
        digitMap.put('6',"mno");
        digitMap.put('7',"pqrs");
        digitMap.put('8',"tuv");
        digitMap.put('9',"wxyz");
        
        
        p(digits,0,"",list,digitMap);
        
        return list;
        
    }
    public static void p(String digits,int i,String pre,List<String> list,HashMap<Character,String> map){
        if(i>=digits.length()){
            list.add(pre);
            return ;
        }
        
        String str = map.get(digits.charAt(i));
        for(int j=0;j<str.length();j++){
            p(digits,i+1,pre+str.charAt(j),list,map);
        }
    }
    public static void main(String[] args) {
		String digits = "23";
		List<String> list = letterCombinations(digits);
		System.out.println(list);
	}
}