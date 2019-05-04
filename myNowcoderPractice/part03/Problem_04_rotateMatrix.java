package part03;

public class Problem_04_rotateMatrix {

	public static void main(String[] args) {
		int[][] arr = {{1,2,3,10},{4,5,6,11},{7,8,9,12},{13,14,15,16}};
		//int[][] arr= {{1}};
		rotate(arr);
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
		}
	}
	public static void rotate(int[][] arr) {
		int aR=0;
		int aC=0;
		int bR=arr.length-1;
		int bC=arr[0].length-1;
		while (aR<bR&&aC<bC) {
			swapCircle(arr, aR++, aC++, bR--, bC--);
		}
	}
	public static void swapCircle(int[][] arr,int aR,int aC,int bR,int bC) {
		if(aR<bR&&aC<bC) {
			int len = bC-aC;
			for(int i=0;i<len;i++) {
				int tmp = arr[aR][aC+i];
				arr[aR][aC+i] = arr[bR-i][aC];
				arr[bR-i][aC] = arr[bR][bC-i];
				arr[bR][bC-i] = arr[aR+i][bC];
				arr[aR+i][bC] = tmp;
			}
		}
		
	}
}
