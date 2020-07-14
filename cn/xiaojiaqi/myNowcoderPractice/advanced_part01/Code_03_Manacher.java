package advanced_part01;

import java.util.Arrays;

/**
 * Manacher算法
 *	 求一个字符串中回文子串的最大长度
 * 
 * 左神的码神版实现
 * 与自己的弱鸡实现
 * @author Narut0
 *
 */
public class Code_03_Manacher {
	//左神的马拉车算法
	public static char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		for (int i = 0; i != res.length; i++) {
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}

	public static int maxLcpsLength(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] charArr = manacherString(str);//原字符串字符两边插入#
		
		int[] pArr = new int[charArr.length];//半径数组
		int index = -1;
		int pR = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i != charArr.length; i++) {
			//下面这句是精髓
			//如果R<=i，则暴力扩
			//如果R>i，则pArr[i]的取值有两种情况，
			//1. 对称点的回文在LR里面，取最小的pArr[2*C-i]
			//2. 对称点的回文超过LR，取最小的R-i+1
			pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
					pArr[i]++;
				else {
					break;
				}
			}
			//如果此时i的回文半径右边界超过了R，记录
			if (i + pArr[i] > pR) {
				pR = i + pArr[i];
				index = i;
			}
			max = Math.max(max, pArr[i]);
		}
		return max/2;
	}


	//自己的马拉车算法。
	public static int manacher(String str) {
		if(str!=null&&str.length()>0) {
			String newStr = shape(str);//获得manacher字符串
			int i=0;  //遍历位置
			int L=-1;  //最右回文串的左、右边界
			int R=-1;  
			int C=-1;   //最右回文串的对称轴（最早）
			int j=0;  //i关于C的对称点
			char[] strc = newStr.toCharArray();
			int[] arr=new int[newStr.length()]; //半径数组
			int max = 0;
			while (i<newStr.length()) {
				if(i>=R) { //情况1.i在最右回文串右边界的外面
					int n = 1; //记录半径
					int cur = i-1; //记录暴力扩的位置
					while (cur>=0&&(2*i-cur)<strc.length) {
						if(strc[cur]==strc[2*i-cur]) {
							n++;
							cur--;
						}else {
							
							break;
						}
					}
					//记录最新的信息
					R = 2*i-cur-1;
					L = cur+1;
					C = i;
					arr[i++] = n;
					max = Math.max(arr[i-1], max);
					
				}else {//情况2.i在R左边
					j = 2*C-i;
					if(arr[j]<j-L+1) {//2.1 对称点j的半径没有超过L
						arr[i++] = arr[j];
						max = Math.max(arr[i-1], max);
					}else if (arr[j]==j-L+1) {//2.2 对称点j的半径刚好到L
						int n = j-L+1;
						int cur = i-n;
						while (cur>=0&&(2*i-cur)<strc.length) {
							if(strc[cur]==strc[2*i-cur]) {
								n++;
								cur--;
							}else {
								
								break;
							}
						}
						if(n>j-L+1) {
							R = 2*i-cur-1;
							L = cur+1;
							C = i;
						}
						arr[i++] = n;
						max = Math.max(arr[i-1], max);
					}else {//2.3  对称点j的半径超过了L
						arr[i++] = j-L+1;
						max = Math.max(arr[i-1], max);
					}
				}
			}
			//System.out.println(C);
			return max/2;
		}
		return -1;
	}
	//马拉车字符串生成,便于奇偶统一处理
	public static String shape(String str) {
		
		String[] strc = str.split("");
		String newStr = "#";
		for(String s:strc) {
			newStr +=s;
			newStr +="#";
		}
		
		return newStr;
		
	}
	//for test
	public static String randString(int length) {
		if(length>0) {
			char[] charArr=  new char[length];
			for(int i=0;i<length;i++) {
				int random = (int)Math.floor(Math.random()*25+97);
				charArr[i] = (char) random;
			}
			return Arrays.toString(charArr);
		}
		return "";
	}
	public static void main(String[] args) {
		
		String str = "babadada";
		System.out.println(manacher(str));
		System.out.println(maxLcpsLength(str));
		//System.out.println('z'+0);
		
//		boolean success = true;
//		for(int i=0;i<99999;i++) {
//			int random = (int)Math.floor(Math.random()*100+5);
//			String randStr = randString(random);
//			int res1 = manacher(randStr);
//			int res2 = maxLcpsLength(randStr);
//			if(res1!=res2) {
//				System.out.println(randStr);
//				System.out.println("res1:"+res1);
//				System.out.println("res2:"+res2);
//				success = false;
//				break;
//			}
//		}
//		System.out.println(success?"Niced!":"Fucking fucked!");
	}

}
