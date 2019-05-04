package part08;
/**
 * 
 *	汉诺塔问题
 *	
 *	解题思路：
 *	n个圆盘从from移到to
 *	可以分解为子问题：
 *	1.n-1个圆盘从from移到help
 *	2.n圆盘从from到to
 *	3.n-1个盘从help到to
 * @author Narut0
 *
 */
public class Code_01_Hanoi {

	public static void hanoi(String from,String to,String help,int n) {
		if(n<=0) {
			return;
		}
		if(n==1) {
			System.out.println("move "+n+" : from "+from+" to "+to);
		}else {
			hanoi(from, help, to, n-1);
			System.out.println("move "+n+" : from "+from+" to "+to);
			hanoi(help, to, from, n-1);
		}
		
	}
	public static void main(String[] args) {
		hanoi("A", "C", "B", 5);
	}
}
