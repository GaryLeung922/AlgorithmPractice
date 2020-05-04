package part01;

/**
 * 小和问题：
 * 在一个数组中，每一个数，其左边比其小的数累加起来，叫做这个数组的小和。求一个数组
        的小和。
   eg:
	[1,3,4,2,5]
	1左边比1小的数，没有；
	3左边比3小的数，1；
	4左边比4小的数，1、3；
	2左边比2小的数，1；
	5左边比5小的数，1、3、4、2；
	所以小和为1+1+3+1+1+3+4+2=16
	
	思路：
	1.暴力解:遍历每个数，一次记录每个数的小和。时间复杂度O(n^2),额外空间复杂度O(1)
	2.单调栈:最差情况，时间复杂度O(n^2),额外空间复杂度O(n)
	3.利用归并排序，在归并的过程中记录小和。时间复杂度O(nlogn),额外空间复杂度O(n)
 * @author Narut0
 *
 */
public class Code_05_SmallSum {
	public static int forceSmallSum(int[] arr) {
		int res = 0;
		if(arr!=null&&arr.length>0) {
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<i;j++) {
					if(arr[j]<arr[i])res+=arr[j];
				}
			}
		}
		return res;
	}
	public static int mergeSmallSum(int[] arr) {
		int res = 0;
		if(arr!=null&&arr.length>0) {
			res+=mergeCore(arr, 0, arr.length-1);
		}
		return res;
	}
	public static int mergeCore(int[] arr,int begin,int end) {
		int res = 0;
		if(begin==end) {
			return res;
		}
		int mid = begin+((end-begin)>>1);
		res+=mergeCore(arr, begin, mid);
		res+=mergeCore(arr, mid+1, end);
		int[] help = new int[end-begin+1];
		int k=0;
		int i=begin;
		int j=mid+1;
		
		while(i<=mid&&j<=end) {
			if(arr[i]<arr[j]) {
				res+=(arr[i]*(end-j+1));//如果arr[i]<arr[j],则证明arr[i]比j,j+1...end都小
				help[k++] = arr[i++];
			}else {
				help[k++] = arr[j++];
			}
		}
		while(i<=mid) {
			help[k++] = arr[i++];
		}
		while (j<=end) {
			help[k++] = arr[j++];
		}
		for(k=0;k<help.length;k++) {
			arr[begin+k] = help[k];
		}
		return res;
	}
	public static void main(String[] args) {
		int[] arr = {1,3,4,2,5};
		int res1 = forceSmallSum(arr);
		int res2 = mergeSmallSum(arr);
		System.out.println("res1:"+res1+"  res2:"+res2);
		
		boolean success = true;
		for(int i=0;i<999999;i++) {
			arr = cn.xiaojiaqi.common.TestUtil.generateArr(1, 100, -100, 100)[0];
			res1 = forceSmallSum(arr);
			res2 = mergeSmallSum(arr);
			if(res1!=res2) {
				success  = false;
				break;
			}
		}
		System.out.println(success?"Nice!":"Fucked!");
	}
	

}
