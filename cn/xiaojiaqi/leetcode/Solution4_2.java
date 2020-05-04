package cn.xiaojiaqi.leetcode;
public class Solution4_2 {
    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        if(arr1!=null&&arr2!=null&&arr1.length>0&&arr2.length>0){
            int len = arr1.length+arr2.length;
            if(len%2==0){
            	double res1 = 0.0;
            	double res2 = 0.0;
            	if(arr1.length<arr2.length) {
            		res1 = binaryFindKth(arr1,arr2,len/2+1,0,0);
            	}else {
            		res1 = binaryFindKth(arr2,arr1,len/2+1,0,0);
				}
            	int p1 = binarySearch(arr1, (int)res1-1);
        		int p2 = binarySearch(arr2, (int)res1-1);
        		if(p1!=-1&&p2!=-1) {
        			res2 = arr1[p1]>arr2[p2]?(double)arr1[p1]:(double)arr2[p2];
        		}else if(p1==-1) {
        			res2 = (double)arr2[p2];
        		}else if(p2==-1) {
        			res2 = (double)arr1[p1];
        		}
        		return (res1+res2)/2.0;
            }else{
                return arr1.length<arr2.length ? binaryFindKth(arr1,arr2,len/2+1,0,0):
                    binaryFindKth(arr2,arr1,len/2+1,0,0);
            }
        }else if(arr1==null||arr1.length==0){
            return arr2.length%2==0?(arr2[arr2.length/2-1]+arr2[arr2.length/2])/2.0:(double)arr2[arr2.length/2];
        }else if(arr2==null||arr2.length==0){
            return arr1.length%2==0?(arr1[arr1.length/2-1]+arr1[arr1.length/2])/2.0:(double)arr1[arr1.length/2];
        }
        return 0.0;
        
    }
    public static double binaryFindKth(int[] arr1, int[] arr2, int k, int i, int j) {
		//默认 arr1长度，比arr2短
		if(i==arr1.length)return (double)arr2[j+k-1];
		if(k==1) return (double)Math.min(arr1[i], arr2[j]); 
		
		int k1 = k/2<=(arr1.length-i) ? i+k/2-1 : arr1.length-1;
		//k1-i+1 为arr1前面的可以过滤的长度
		int k2 = j+k-(k1-i+1)-1;
		if(arr1[k1]==arr2[k2]) return (double)arr1[k1];
		else if(arr2[k2]>arr1[k1]) {
			return binaryFindKth(arr1,arr2,k-(k1-i+1),k1+1,j);
		}else {
			return arr2.length-j-k+k/2>arr1.length-i ? binaryFindKth(arr1, arr2, (k1-i+1),i,k2+1):
				binaryFindKth(arr2, arr1, (k1-i+1), k2+1, i);
		}
	}
    public static int binarySearch(int[] arr,int k) {
    	if(k<arr[0])return -1;
    	int begin = 0;
    	int end = arr.length-1;
    	int mid = begin+((end-begin)>>1);
    	while (end>begin) {
			if(arr[mid]>k) {
				end = mid-1;
			}else if(arr[mid]<k){
				begin = mid+1;
			}else {
				return mid;
			}
			mid = begin+((end-begin)>>1);
		}
    	return begin;
    }
    public static void main(String[] args) {
		int[] arr1 = {1};
		int[] arr2 = {2,3,4,5,6};
		double ans =findMedianSortedArrays(arr1, arr2);
		System.out.println(ans);
//		int ans = binarySearch(arr2, 0);
//		System.out.println(ans);
	}
}