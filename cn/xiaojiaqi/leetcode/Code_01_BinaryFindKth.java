package cn.xiaojiaqi.leetcode;
/**
 * 两个有序数组中，找到找到升序的第k个数
 * 第1小的数，认为是最小的数
 * @author Narut0
 *
 */
public class Code_01_BinaryFindKth {

	public static int binaryFindKth(int[] arr1,int[] arr2,int k) {
		if(arr1!=null&&arr2!=null&&k>0&&arr1.length+arr2.length>=k) {	
			return arr1.length>arr2.length?binaryFindKth(arr2, arr1, k,0,0):binaryFindKth(arr1, arr2, k,0,0);
		}
		return -1;
	}

	public static int binaryFindKth(int[] arr1, int[] arr2, int k, int i, int j) {
		//默认 arr1长度，比arr2短
		if(i==arr1.length)return arr2[j+k-1];
		if(k==1) return Math.min(arr1[i], arr2[j]); 
		
		int k1 = k/2<=(arr1.length-i) ? i+k/2-1 : arr1.length-1;
		int k2 = j+k-k/2-1;
		if(arr1[k1]==arr2[k2]) return arr1[k1];
		else if(arr2[k2]>arr1[k1]) {
			return binaryFindKth(arr1,arr2,k-k/2,k1+1,j);
		}else {
			return arr2.length-j-k+k/2>arr1.length-i ? binaryFindKth(arr1, arr2, k/2,i,k2+1):
				binaryFindKth(arr2, arr1, k/2, k2+1, i);
		}
	}
	public static void main(String[] args) {
		int[] arr1 = {1,2,5,9,13};
		int[] arr2 = {0,8,9,16};
		for(int i=0;i<arr1.length+arr2.length;i++) {
			int ans = binaryFindKth(arr1, arr2, i+1);
			System.out.println(ans);
		}
		
	}

}
