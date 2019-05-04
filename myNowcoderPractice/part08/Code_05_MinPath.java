package part08;
/**
 * 题目描述：
 * 给你一个二维数组，二维数组中的每个数都是正数，要求从左上
 *	角走到右下角，每一步只能向右或者向下。沿途经过的数字要累
 *	加起来。返回最小的路径和。
 *
 *解题思路：
 *1.暴力递归：
 *每一个位置都有两个选择，向下or向右
 *注意递归边界
 *2.动态规划DP
 *暴力递归改DP
 * @author Narut0
 *
 */
public class Code_05_MinPath {

	public static int minPath(int[][] arr,int i,int j,int sum) {
		if(arr!=null) {
			if(i>=arr.length||j>=arr[0].length) {
				return Integer.MAX_VALUE;
			}else if (i==arr.length-1&&j==arr[0].length-1) {
				return sum+arr[i][j];
			}else if (j==arr[0].length-1) {
				return minPath(arr, i+1, j, sum+arr[i][j]);
			}else if (i==arr.length-1) {
				return minPath(arr, i, j+1, sum+arr[i][j]);
			}
			else {
				int right = minPath(arr, i, j+1, sum+arr[i][j]);
				int down = minPath(arr, i+1, j, sum+arr[i][j]);
				return right>down?down:right;
			}
		}
		return 0;
	}
	public static int dpMinPath(int[][] arr) {
		if(arr!=null) {
			int r = arr.length;
			int c = arr[0].length;
			int[][] dp = new int[r][c];
			
			dp[r-1][c-1] = arr[r-1][c-1];
			for(int i=c-2;i>=0;i--) {
				dp[r-1][i] = arr[r-1][i] + dp[r-1][i+1];
			}
			for(int j=r-2;j>=0;j--) {
				dp[j][c-1] = arr[j][c-1] + dp[j+1][c-1];
			}
			for(int i=r-2;i>=0;i--) {
				for(int j=c-2;j>=0;j--) {
					dp[i][j] = arr[i][j] + (dp[i+1][j]>dp[i][j+1]?dp[i][j+1]:dp[i+1][j]) ;
				}
			}
			return dp[0][0];
		}
		return 0;
	}
	
	// for test
	public static int[][] generateRandomMatrix(int rowSize, int colSize) {
		if (rowSize < 0 || colSize < 0) {
			return null;
		}
		int[][] result = new int[rowSize][colSize];
		for (int i = 0; i != result.length; i++) {
			for (int j = 0; j != result[0].length; j++) {
				result[i][j] = (int) (Math.random() * 10);
			}
		}
		return result;
	}
		
	public static void main(String[] args) {
		int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
		System.out.println(minPath(m, 0, 0, 0));
		System.out.println(dpMinPath(m));
		
		for(int i=0;i<999999;i++) {
			m = generateRandomMatrix((int)Math.ceil(Math.random()*10+1),(int)Math.ceil(Math.random()*10+1));
			if(minPath(m, 0, 0, 0)!=dpMinPath(m)) {
				System.out.println("false");
			}
		}
	}

}
