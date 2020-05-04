package part03;

public class Problem_03_printRotateMatrix {

	public static void main(String[] args) {
		int[][] arr = {{1}};
		rotatePrint(arr);
		
	}
	public static void rotatePrint(int[][] arr) {
		int aR = 0;
		int aC = 0;
		int bR = arr.length-1;
		int bC = arr[0].length-1;
		while(aR<=bR&&aC<=bC) {
			print(arr, aR++, aC++, bR--, bC--);
		}
		
	}
	public static void print(int[][] arr,int aR,int aC,int bR,int bC) {
		if(aR<bR&&aC<bC) {
			for(int i=aC;i<bC;i++) {//从左到右打印行
				System.out.print(arr[aR][i]+" ");
			}
			for(int i=aR;i<bR;i++) {//从上到下打印列
				System.out.print(arr[i][bC]+" ");
			}
			for(int i=bC;i>aC;i--) {//从右到左打印行
				System.out.print(arr[bR][i]+" ");
			}
			for(int i=bR;i>aR;i--) {//从下到上打印列
				System.out.print(arr[i][aC]+" ");
			}
		}else if (aR==bR) {//a和b处在同一行
			for(int i=aC;i<bC;i++) {//从左到右打印行
				System.out.print(arr[aR][i]+" ");
			}
			System.out.print(arr[bR][bC]);
		}else if(aC==bC){//a和b处在同一列
			for(int i=aR;i<bR;i++) {//从上到下打印列
				System.out.print(arr[i][bC]+" ");
			}
			System.out.println(arr[bR][bC]);
		}
	}

}
