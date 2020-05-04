package advanced_part01;

import java.util.Arrays;

import cn.xiaojiaqi.common.TestUtil;

/**
 * BFPRT算法
 * 	求一个数组中第k大/小的数
 * @author Narut0
 *
 */
public class Code_04_BFPRT {
	//小组的中位数
	public static int getMedian(int[] arr,int begin,int end) {
		for(int i=begin;i<end;i++) {
			for(int j=begin+1;j<end-(i-begin);j++) {
				if(arr[j]<arr[j-1]) {
					arr[j] = arr[j]^arr[j-1];
					arr[j-1] = arr[j-1]^arr[j];
					arr[j] = arr[j-1]^arr[j];
				}
			}
		}
		//System.out.println(Arrays.toString(arr));
		return arr[((end+begin)-1)/2];
	}
	//中位数组成的小组的中位数
	public static int medianOfMedians(int[] arr,int begin,int end) {
		int num = end-begin+1;
		int offset = num%5==0?0:1;
		int[] mArr = new int[num/5+offset];
		for(int i=0;i<mArr.length;i++) {
			int beginI = begin+i*5;
			int endI = beginI+4;
			mArr[i] = getMedian(arr, beginI, Math.min(end, endI));
		}
		//递归调用bfprt求中位数
		return bfprt(mArr, 0, mArr.length-1, mArr.length/2);
	}
	public static int[] copyArr(int[] arr) {
		int[] copy = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			copy[i] = arr[i];
		}
		return copy;
	}
	public static int getBfprt(int[] arr,int k) {
		if(arr!=null&&arr.length!=0) {
			int[] copy = copyArr(arr);
			
			return bfprt(copy, 0, copy.length-1, k-1);
		}
		return -1;
	}
	public static void main(String[] args) {
		//for test
		int[][] arr = TestUtil.generateArr(999999, 90,0,100);
		for(int i=0;i<9999;i++) {
			int ans1 = getBfprt(arr[i], 5);
			Arrays.sort(arr[i]);
			int ans2 = arr[i][4];
			if(ans1!=ans2) {
				System.out.println("false");
			}else {
				System.out.println(ans1);
			}
		}
		
		//int i=1;
		//swap(arr, i++, 2);
		
		//System.out.println(Arrays.toString(partition(arr, 0, 6, 4)));
//		for(int i=0;i<arr.length;i++) {
//			System.out.println(getBfprt(arr, i+1));
//		}
		
	}
	//BFPRT算法主体，[begin,end]左闭右闭
	public static int bfprt(int[] arr,int begin,int end,int k) {
		if(begin==end) {//递归调用的边界
			return arr[begin];
		}
		int pivot = medianOfMedians(arr, begin, end);
		int[] pivotRange = partition(arr,begin,end,pivot);
		if(k >= pivotRange[0]&& k<=pivotRange[1]) {//若要求的数在等于区域，直接返回即可
			return arr[k];
		}else if (k<pivotRange[0]) {//在小于区域，递归小于区域
			return bfprt(arr, begin, pivotRange[0]-1, k);
		}else {//在大于区域，递归大于区域
			return bfprt(arr, pivotRange[1]+1, end, k);
		}
		
	}
	//荷兰国旗的partition分区
	private static int[] partition(int[] arr, int begin, int end, int pivot) {
		int left = begin;
		int right = end;
		for(int i=begin;i<=right;i++) {
			if(arr[i]<pivot) {
				swap(arr,i,left++);
			}else if (arr[i]>pivot) {
				swap(arr, right--, i--);
			}else {
				
			}
		}
		//System.out.println(Arrays.toString(arr));
		return new int[] {left,right};
	}
	private static void swap(int[] arr, int i, int j) {
		if(i==j) {//如果i==j，下面的位交换出错。因为arr[i]和arr[j]指向同一个对象
			return;
		}
		arr[i] = arr[i]^arr[j];
		arr[j] = arr[j]^arr[i];
		arr[i] = arr[j]^arr[i];
		//System.out.println(Arrays.toString(arr));
	}
	
}
