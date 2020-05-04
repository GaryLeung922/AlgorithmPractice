package part08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 
 * 问题描述：
 * 打印一个字符串的全部排列
 * 进阶：
 * 按字典序打印字符串的全排列
 * 解题思路：
 * - 与正常做全排列题目一样，n个字符中选取一个作为头，后面的n-1个全排列
 * n个字符的父问题化为n-1的子问题，递归求解
 * - 先将源字符串按字典序重新组织好，再进行上面的递归即可。
 * （若字符串有重复字符，则全排列里有重复，可用HashSet去重）
 * @author Narut0
 *
 */
public class Code_03_Print_All_Permutations {

	public static void permutation(String str,String begin) {
		if(str.length()==0) {
			System.out.println(begin+str);
		}else {
			for(int i=0;i<str.length();i++) {
				char ch = str.charAt(i);
				String left = str.substring(0,i);
				String right = str.substring(i+1);
				permutation(left+right, begin+ch);
			}
			
		}

	}
	public static void main(String[] args) {
		
		char[] ctrs = {'c','b','a','A','b'};
		Arrays.sort(ctrs);
		permutation(String.copyValueOf(ctrs),"");
		String str = "sadf";
		HashSet<String> set  = new HashSet<>();
		ArrayList<String> arr = new ArrayList<>();
		
		//System.out.println("abc".substring(1));
	}

}
