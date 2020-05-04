package advanced_part01;
/**
 * Manacher算法，返回最长的回文子串
 * 
 */
public class Code_05_Manacher {

	public static String shape(String str) {
		StringBuilder newstr = new StringBuilder("#");
		String[] strs  = str.split("");
		for(String s:strs) {
			newstr.append(s+"#");
		}
		return newstr.toString();
	}
	public static String Manacher(String str) {
		int max = 0;
		int maxIndex = -1;
		if(str!=null&&str.length()>0) {
			System.out.println(shape(str));
			char[] chtr = shape(str).toCharArray();
			int i=0;
			int R=-1;
			int C=-1;
			int ii=0;
			int[] help = new int[chtr.length];
			while(i<chtr.length) {
				if(i>=R) {
					int n = 1;
					int cur = i+n;
					while(cur<chtr.length&&i-n>=0) {
						if(chtr[cur]==chtr[i-n]) {
							n++;
							cur++;
						}else {
							break;
						}
					}
					R = i+n-1;
					C = i;
					help[i++] = n;
				}else {
					ii = 2*C-i;
					if(help[ii]!=R-i+1) {
						//help[i++] = help[ii]>R-i+1?R-i+1:help[ii];
						//上面的写法有天坑，首先判断表达式help[ii]>R-i+1为真，然后i就自增了。help[j] = R-j+1;  (j=i+1)
						help[i] = help[ii]>R-i+1?R-i+1:help[ii];
						i++;
					}else {
						int n=help[ii];
						int cur = i+n;
						while(cur<chtr.length&&i-n>=0) {
							if(chtr[cur]==chtr[i-n]) {
								n++;
								cur++;
							}else {
								break;
							}
						}
						int newR = i+n-1;
						C = newR>R? i:C;
						R = newR;
						help[i++] = n;
						
					}
					
				}
				if(help[i-1]>max) {
					max = help[i-1];
					maxIndex = i-1;
				}
			}
			boolean even = maxIndex%2==0?true:false;
			System.out.println("max:"+max+"  maxIndex:"+maxIndex);
			maxIndex/=2;
            max = (max-1)/2;
			System.out.println("max:"+max+"  maxIndex:"+maxIndex);
			if(even) {
				return str.substring(maxIndex-max,maxIndex+max);
			}else {
				return str.substring(maxIndex-max,maxIndex+max+1);
			}
			
            
		}
		return "";
	}
	public static void main(String[] args) {
//		String str1 = "cbbd";
//		String res1 = Manacher(str1);
//		System.out.println(res1);
//		String str = "ac";
//		String res = Manacher(str);
//		System.out.println(res);
//		String str2 = "abb";
//		String res2 = Manacher(str2);
//		System.out.println(res2);
		String str3 = "babadada";
		String res3 = Manacher(str3);
		System.out.println(res3);
		
		int i=0;
		int[] arr = {0,0,0};
		arr[i++] = 4>3?i:9;
		System.out.println(arr[0]);
	}

}
