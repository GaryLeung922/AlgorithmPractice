package advanced_part04;

import java.util.Arrays;
import java.util.HashMap;

public class Code_01_LongestSumSubArrayLength {
	
	public static int getLength(int[] arr,int aim) {
		if(arr!=null&&arr.length>0) {
			HashMap<Integer, Integer> map = new HashMap<>();
			int sum = 0;
			int max = Integer.MIN_VALUE;
			map.put(0, -1);
			for(int i=0;i<arr.length;i++) {
				sum+=arr[i];
				if(map.containsKey(sum-aim)) {
					max = Math.max(max, i-map.get(sum-aim));
				}
				if(!map.containsKey(sum)) {
					map.put(sum, i);
				}
			}
			if(max==Integer.MIN_VALUE) {
				return -1;
			}
			return max;
		}
		return -1;
		
	}
	//for test
	public static int getLengthForce(int[] arr,int aim) {
		if(arr!=null&&arr.length>0) {
			int max = Integer.MIN_VALUE;
			for(int i=0;i<arr.length;i++) {
				int sum = 0;
				for(int j=i;j<arr.length;j++) {
					sum+=arr[j];
					if(sum==aim) {
						max = Math.max(max, j-i+1);
					}
				}
				
			}
			if(max==Integer.MIN_VALUE) {
				return -1;
			}
			return max;
		}
		return -1;
	}
	public static void main(String[] args) {
//		int[] arr = {7,3,2,1,1,-7,7,7};
//		int aim = 7;
//		System.out.println(getLength(arr, aim));
//		System.out.println(getLengthForce(arr, aim));
		int[][] arr = MyUtils.TestUtil.generateArr(999999, 10, -10, 10);
		for(int i=0;i<999999;i++) {
			int aim = (int) Math.round(Math.random()*20);
			int res1 = getLength(arr[i], aim);
			int res2 = getLength(arr[i], aim);
			if(res1!=res2) {
				System.out.println(Arrays.toString(arr[i]));
				break;
			}
			
			//System.err.println(res2);
		}
		System.out.println("over");
		
		
	}

}
