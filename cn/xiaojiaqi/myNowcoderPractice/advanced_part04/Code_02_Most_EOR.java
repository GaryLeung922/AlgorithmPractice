package advanced_part04;

import java.util.Arrays;
import java.util.HashMap;

public class Code_02_Most_EOR {

	public static int mostEOF(int[] arr) {
		if(arr!=null&&arr.length>0) {
			int[] dp = new int[arr.length];
			dp[0] = arr[0]==0 ? 1 : 0;
			HashMap<Integer, Integer> map = new HashMap<>();
			map.put(0, -1);
			map.put(arr[0], 0);
			int xor = 0;
			for(int i=1;i<arr.length;i++) {
				xor^=arr[i];
				if(map.containsKey(xor)) {
					int k = map.get(xor)==-1? 0:map.get(xor);
					dp[i] = dp[k]+1;
				}
				dp[i] = Math.max(dp[i-1], dp[i]);
				map.put(xor, i);
			}
			return dp[arr.length-1];
		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] arr = cn.xiaojiaqi.common.TestUtil.generateArr(99999, 100, 0, 10);
		boolean succeed = true;
		for(int i=0;i<arr.length;i++) {
			int res1 = mostEOF(arr[i]);
			int res2 = Code_06_Most_EOR.mostEOR(arr[i]);
			if(res1!=res2) {
				succeed  =false;
				System.out.println(Arrays.toString(arr[i]));
				System.out.println(res1+":"+res2);
				
			}
			
		}
		System.out.println(succeed?"nice":"fucked");
		
	}
}
