package part07;

import java.util.Arrays;
import java.util.Comparator;
/**
 * 
	问题描述：（剑指offer）
	输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
	例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
	引申：
	给定一个字符串类型的数组strs，找到一种拼接方式，使得把所
	有字符串拼起来之后形成的字符串具有最低的字典序。
	
	解题思路：
	只是按字典序从小到大拼接，是错误的。
	反例：
	"b"和"ba"
	最低的字典序为："bab"而不是"bba"
	所以排序思路应该改为若a+b<b+a,则a排在b前。
 * @author Narut0
 *
 */
public class Code_05_LowestLexicography {

	//比较器
	public static class MyComparator implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			
			return (o1+o2).compareTo(o2+o1);
		}
		
	}
	public static void lowestString(String[] strs) {
		Arrays.sort(strs, new MyComparator());
		String res = "";
		for(String str:strs) {
			res+=str;
		}
		System.out.println(res);
		
	}
	public static void main(String[] args) {
		String[] strs = {"jibw", "ji", "jp", "bw", "jibw"};
		lowestString(strs);
		String[] str2 = { "ba", "b" };
		lowestString(str2);
	}

}
