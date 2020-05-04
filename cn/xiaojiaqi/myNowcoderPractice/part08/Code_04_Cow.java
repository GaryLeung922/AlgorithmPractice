package part08;
/**
 * 
 * w问题描述：
 * 母牛每年生一只母牛，新出生的母牛成长三年后也能每年生一只
 * 母牛，假设不会死。求N年后，母牛的数量。
 * 进阶：如果母牛只能活10年呢？
 * 
 * 解题思路：
 * 类似于斐波那契数列，找出规律即可
 * @author Narut0
 *
 */
public class Code_04_Cow {

	public static int cowNums(int n) {
		if(n>=1) {
			if(n==1) {
				return 1;
			}else if (n==2) {
				return 2;
			}else if (n==3) {
				return 3;
			}else {
				return cowNums(n-1)+cowNums(n-3);
			}
			
		}
		return 0;
	}
	public static void main(String[] args) {
		for(int i=0;i<8;i++) {
			System.out.println(cowNums(i));
		}
		System.out.println(cowNums(11));
	}

}
