package part08;
/**
 * 
	问题描述：
	打印一个字符串的全部子序列，包括空字符串
	
	解题思路：
	字符串的每个位置有两种状态，打印or不打印
 * @author Narut0
 *
 */


public class Code_02_Print_All_Subsquences {

	public static void printAllSubsquences(String str,int i,String res) {
		if(i>=str.length()) {
			System.out.println(res);
		}else {
			
			printAllSubsquences(str, i+1,res);
			res = res + str.charAt(i);
			printAllSubsquences(str, i+1, res);
		}
	}
	public static void main(String[] args) {
		String str = "abc";
		printAllSubsquences(str, 0, "");
	}

}
