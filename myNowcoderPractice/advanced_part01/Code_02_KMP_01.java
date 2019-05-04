package advanced_part01;

/**
 * 题目描述：（2017京东原题）
 * 给你一个字符串，你在后面添加一些字符，使新的字符串包含两个原始串。
 * 要求：时间复杂度为O(N)，且添加的字符最少
 * eg:原始串："abcabc"
 * 		新字符串："abcabcabc"
 * 
 * 解题思路：
 * KMP的应用
 * 求原始串的next数组,再多求出str.length位置上的next;
 * 然后在原始串的后面添加上length位置上的最长前缀的后面部分即可。
 * @author Narut0
 *
 */
public class Code_02_KMP_01 {

	public static int[] nextPlus(String str) {
		if(str!=null&&str.length()>0) {
			if(str.length()==1) {
				return new int[] {-1};
			}
			char[] strc = str.toCharArray();
			int[] next = new int[str.length()+1];
			next[0] = -1;
			next[1] = 0;
			int i=2;
			int ch = next[1];
			while (i<next.length) {
				if(strc[ch]==strc[i-1]) {
					next[i]=next[i-1]+1;
					ch = next[i++];
				}else {
					if(ch<=0) {
						next[i++] = 0;
					}else {
						ch = next[ch];
					}
				}
			}
			return next;
		}
		return null;
	}
	public static String getNewStr(String str) {
		if(str!=null&&str.length()>0) {
			int[] next = nextPlus(str);
			if(next.length==1) {
				return str+str;
			}else {
				int i = next[next.length-1];
				String rear = str.substring(i);
				return str+rear;
			}
		}
		return "";
		
	}
	public static void main(String[] args) {
		String str = "abcab";
		System.out.println(getNewStr(str));
	}

}
