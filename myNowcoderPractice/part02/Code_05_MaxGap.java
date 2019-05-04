package part02;

import java.util.Arrays;
/**
 * Maximum Gap
 *	
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

	Return 0 if the array contains less than 2 elements.
	
	Note:

	1.You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
	2.Try to solve it in linear time/space.
 * @author Narut0
 *
 */
public class Code_05_MaxGap {

	public static int maxGap(int[] arr) {
		int maxGap = 0;
		if(arr!=null&&arr.length>1) {
			int minOfArr = Integer.MAX_VALUE;
			int maxOfArr = Integer.MIN_VALUE;
			for(int i=0;i<arr.length;i++) {
				minOfArr = Math.min(arr[i], minOfArr);
				maxOfArr = Math.max(arr[i], maxOfArr);
			}
			int gap = (int) Math.ceil((maxOfArr-minOfArr+1)/(double)(arr.length+1));
			//System.out.println("gap:"+gap);
			//准备每个桶的min，max和标志
			int[] min = new int[arr.length+1];
			int[] max = new int[arr.length+1];
			boolean[] noEmpty = new boolean[arr.length+1];//桶为空，置为false;
			for(int i=0;i<arr.length;i++) {
				int bucketId = bucket(arr[i],minOfArr,maxOfArr,arr.length);
				//System.out.println("bucketId:"+bucketId+"  arr[i]:"+arr[i]);
				min[bucketId] = noEmpty[bucketId]==false ? arr[i] : Math.min(min[bucketId], arr[i]);
				max[bucketId] = noEmpty[bucketId]==false ? arr[i] : Math.max(max[bucketId], arr[i]);
				noEmpty[bucketId]=true;
			}
			int preMax = Integer.MAX_VALUE;//前一个非空桶的最大值
			for(int i=0;i<arr.length+1;i++) {
				if(!noEmpty[i])continue;
				maxGap = preMax==Integer.MAX_VALUE ? maxGap : Math.max(maxGap, min[i]-preMax);
				preMax = max[i];
			}
		}
		return maxGap;
	}

//  需要考虑溢出。 要用long
   public static int bucket(long n,long begin,long end,long size){
   //下面的式子好好理解。如果nums={3,1,2,5,7} 那么7对应的id刚好为5(第6个桶)
   	return (int)((n-begin)*size/(end-begin));
       
   }
	private static int comparatorForTest(int[] arr) {
		Arrays.sort(arr);
		int maxGap = 0;
		for(int i=1;i<arr.length;i++) {
			maxGap = Math.max(maxGap, arr[i]-arr[i-1]);
		}
		return maxGap;
	}
	public static void main(String[] args) {
		int[] arr = {5,42,68};
		int res = maxGap(arr);
		System.out.println(res);
		
		boolean success = true;
		for(int i=0;i<99999;i++) {
			arr = MyUtils.TestUtil.generateArr(1, 10, 0, 100)[0];
			int res1 = maxGap(arr);
			int res2 = comparatorForTest(arr);
			if(res1!=res2) {
				success  = false;
				System.out.println(Arrays.toString(arr));
				System.out.println(res1);
				System.out.println(res2);
				break;
			}
		}
		System.out.println(success?"Nice!":"Fucking fucked!");
		
//		List<Integer> list = new ArrayList<>(Arrays.asList(12,3));
//		for(Integer i:list) {
//			System.out.println(i);
//		}
	}
	
}
