package advanced_part07;

public class Code_02_CardsInLine2 {

	public static void whoWin(int[] arr) {
		System.out.println(F(arr,0,arr.length-1,0));
	}

	public static int F(int[] arr, int i, int j,int sum) {
		if(i==j) {
			return sum+arr[i];
		}else if(j-i==1){
			sum += arr[i]>arr[j]?arr[i]:arr[j];
			return sum;
		}else {
//			int p1 = S(arr,i+1,j,0);
//			int p2 = S(arr,i,j-1,0);
			return 0; 
		}
	}

}
