package advanced_part01;
/*
 * 
 */
public class Code_06_Manacher {
	public static int manacher(String s) {
		if(s==null||s.length()<1)return 0;
		
		s = manacherStr(s);
		char[] sch = s.toCharArray();
		int[] parr = new int[sch.length];
		//int i=0;
		int R=-1;
		int C=-1;
		int max = Integer.MIN_VALUE;
		for(int i=0;R<sch.length-1;i++) {
			parr[i] = i>R ? 1 : Math.min(R-i+1, parr[2*C-i]);
			
			while(i+parr[i]<sch.length&&i-parr[i]>-1) {
				if(sch[i+parr[i]]==sch[i-parr[i]]) {
					parr[i]++;
				}else {
					break;
				}
			}
			if(i+parr[i]-1>R) {
				C = i;
				R = i+parr[i]-1;
				max = Math.max(max, parr[i]);
			}
			
		}
		return max/2;
		
	}
	public static String manacherStr(String s) {
		StringBuilder res = new StringBuilder("#");
		for(char c:s.toCharArray()) {
			res.append(c+"#");
		}
		return res.toString();
	}
	//左神
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
	public static void main(String[] args) {
		String s = "asdfinbafnasdnnnn";
		int ans1 = manacher(s);
		int ans2 = maxLcpsLength(s);
		System.out.println(ans1);
		System.out.println(ans2);
		
		boolean success = true;
		for(int i=0;i<999999;i++) {
			s = MyUtils.TestUtil.generateStr(100, false);
			ans1 = manacher(s);
			ans2 = maxLcpsLength(s);
			if(ans1!=ans2) {
				success = false;
				System.out.println(s);
				System.out.println("ans1:"+ans1+"   ans2:"+ans2);
			}
		}
		System.out.println(success ? "Nice" : "Fucked");
	}
}
