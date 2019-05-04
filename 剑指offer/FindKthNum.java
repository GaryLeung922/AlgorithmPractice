package cn.xiaojiaqi.test;
public class FindKthNum {
    public static int findKthNum(int[] arr1, int[] arr2, int kth) {
    	if(kth<=0||(arr1==null&&arr2==null))return -1;
    	if(arr1==null&&arr2!=null) {
    		return arr2.length>=kth ? arr2[kth-1] : -1; 
    	}
    	if(arr2==null&&arr1!=null) {
    		return arr1.length>=kth ? arr1[kth-1] : -1; 
    	}
    	
    	return findKthNum(arr1,arr2,0,arr1.length-1,0,arr2.length-1,kth);
    }
	private static int findKthNum(int[] arr1, int[] arr2, int i, int j, int u, int v, int k) {
		if(j-i>v-u) {
			return findKthNum(arr2, arr1, u, v, i, j, k);
		}
		if(i>j) {
			return arr2[u+k-1];
		}
		if(k==1) {
			return arr1[i]<arr2[u] ? arr1[i] : arr2[u]; 
		}
		
		
		int mid1 = i+((j-i)>>1);
		int mid2 = u+((v-u)>>1);
		if(arr1[mid1]<arr2[mid2]) {
			if(k<=mid1-i+mid2-u+1) {
				v = mid2-1;
			}else {
				k -= (mid1-i+1);
				i = mid1+1;
				
			}
			
		}else {
			if(k<=mid1-i+mid2-u+1) {
				j = mid1-1;
			}else {
				k -= (mid2-u+1);
				u = mid2+1;
				
			}
		}
		return findKthNum(arr1, arr2, i, j, u, v, k);
	}
	public static void main(String[] args) {
		int[] arr1 = {3,10};
		int[] arr2 = {5,8,13,17,31,33,37,42,55,66,77,88};
		
		int ans = findKthNum(arr1, arr2, 10);
		System.out.println(ans);
		
		int i = 0;
	      switch(i){
	         case 0:
	            System.out.println("0");
	         case 1:
	            System.out.println("1");
	            break;
	         case 2:
	            System.out.println("2");
	         default:
	            System.out.println("default");
	      }
	}
}