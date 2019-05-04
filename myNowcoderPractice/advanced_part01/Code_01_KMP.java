package advanced_part01;
/**
 * KMP算法 
 * 	比较str2是否是str1的子串
 * @author Narut0
 *
 */
public class Code_01_KMP {

	public static int getIndexOf(String str1,String str2) {
		int[] next = getNext(str2.toCharArray());
		if(next.length>0&&str2.length()<=str1.length()) {
			int a=0;//指向str1
			int b=0;//指向str2
			while(a<str1.length()&&b<str2.length()) {
				if(str1.charAt(a)==str2.charAt(b)) {//相同则同时后移一位
					a++;
					b++;
				}else {//不相同
					if(next[b]<0) {//如果要跳出了数组（-1），则表明b=0，第一位不相同，a向后移一位
						a++;
					}else {
						b = next[b];//b跳到b的最长前缀的后一位，数值上等于next[b];
					}
				}
			}
			return b==str2.length()? a-b:-1;//如果b走完的全程，则表明匹配成功
		}
		return -1;
	}
	public static int[] getNext(char[] str ) {
		if(str!=null||str.length>=1) {
			if(str.length==1) {
				return new int[] {-1};
			}else if (str.length==0) {
				return new int[] {};
			}
			int[] next = new int[str.length];
			next[0] = -1;
			next[1] = 0;
			int i = 2;//从2位置开始遍历
			int ch = next[1];//ch表示当前遍历的前一个位置的next
			while(i<str.length) {
				//如果遍历的前一个位置和其next指向的位置相同，则当前位置的next等于前一个位置的next+1
				if(str[ch]==str[i-1]) {
					/*next[i] = next[i-1]+1;//
					ch = next[i++];*/
					next[i++] = ++ch;
				}else {
					//若ch已经跳出next范围，则当前遍历的位置next=0,否则的话继续向前跳
					if(ch<=0) {
						next[i++] = 0;
					}else {
						ch = next[ch];
					}
				}
				
			}
			return next;
		}
		return new int[] {};
	}
	public static void main(String[] args) {
//		String str = "";
//		int[] next = getNext(str.toCharArray());
//		System.out.println(Arrays.toString(next));
		String str1 = "abcabcababaccc";
		String str2 = "abab";
		System.out.println(getIndexOf(str1, str2));
	}
}
