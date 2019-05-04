package part03;

public class Problem_05_zigzagPrintMatrix {

	public static void main(String[] args) {
		//int[][] arr= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		//int[][] arr= {{2,1}};
		int[][] arr= {{1},{2}};
		zigzagPrint(arr);
	}
	public static void zigzagPrint(int[][] arr) {
		int aR = 0;
		int aC = 0;
		int bR = 0;
		int bC = 0;
		boolean up2down=false;
		while (aR<=arr.length-1&&aC<=arr[0].length-1) {
			print(arr, aR, aC, bR, bC, up2down);
			up2down=!up2down;
			
			aR = aC==arr[0].length-1?aR+1:aR;//要先判断通过aC确定aR,再给aC赋值
			aC = aC==arr[0].length-1?arr[0].length-1:aC+1;
			
			bC = bR==arr.length-1?bC+1:bC;//同理
			bR = bR==arr.length-1?arr.length-1:bR+1;
			
		}
	}
	public static void print(int[][] arr,int aR,int aC,int bR,int bC,boolean up2down) {
		if(up2down) {
			while (aR<=bR&&aC>=bC) {
				System.out.print(arr[aR++][aC--]+" ");
			}
		}else {
			while (aR<=bR&&aC>=bC) {
				System.out.print(arr[bR--][bC++]+" ");
			}
		}
	}

}
