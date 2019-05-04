package part05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * r
同源词分析
有一个字符串数组，每个字符串全部由小写字母组成，如果两个字符串包含的字母种类相同就称为一组。
例如：
["abc","aabbc","ab","baba","c"]数组中，同源词分组有3组
["abc","aabbc"],["ab","baba"],["c"]
 * @author Narut0
 *
 */
public class Code_02_WordsClassifier {
	
	/**
	 * 一个整型占32bit，从第一个bit到第26个bit，分别对应a-z，bit位1表示有这个字母，反之则没有
	 * @param str
	 * @return
	 */
	public static int bitmap(String str) {
		if(!"".equals(str)) {
			int bit = 0;
			char[] chs = str.toCharArray();
			for(int i=0;i<chs.length;i++) {
				//System.out.println("????");
				//int j = 1<<(chs[i]-'a');
				//System.out.println(j);
				bit = bit|(1<<(chs[i]-'a'));
			}
			return bit;
		}
		return 0;
	}
	
	public static int classifier(List<String> arr) {
		HashSet<Integer> set = new HashSet<>();
		for(String str:arr) {
			set.add(bitmap(str));
		}
		return set.size();
	}
	public static void main(String[] args) {
		List<String> arr = new ArrayList<>();
		arr.add("abc");
		arr.add("aabbcd");
		arr.add("ab");
		arr.add("baba");
		arr.add("c");
		
		System.out.println(classifier(arr));
		
	}
	
	
	
}
