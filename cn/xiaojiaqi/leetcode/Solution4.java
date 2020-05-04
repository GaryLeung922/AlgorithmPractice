package cn.xiaojiaqi.leetcode;

public class Solution4 {

	public static double findMedian(int[] arr1,int[] arr2) {
		if(arr1!=null&&arr2!=null&&arr1.length>0&&arr2.length>0) {
			int lens = arr1.length+arr2.length;
			int a1 = 0;
			int b1 = arr1.length-1;
			int m1 = a1+((b1-a1)>>1);
			int a2 = 0;
			int b2 = arr2.length-1;
			int m2 = a2+((b2-a2)>>1);
			if(lens%2==1) {
				while(b1>=a1&&b2>=a2) {
					if(arr1[m1]>arr2[m2]) {
						b1 = m1+m2+1>lens/2 ? m1-1:m1;
						a2 = m1+m2<lens/2 ? m2+1:m2;
					}else if(arr1[m1]<arr2[m2]) {
						a1 = m1+m2<lens/2 ? m1+1:m1;
						b2 = m1+m2+1>lens/2 ? m2-1:m2;
					}else {
						return arr1[m1];
					}
					m1 = a1+((b1-a1)>>1);
					m2 = a2+((b2-a2)>>1);
				}
				return b1==a1?arr1[a1]:arr2[a2];
			}else {
				//先判断下,是否两个中位数在一个数组中
				if(lens==2) {
					return (arr1[0]+arr2[0])/2.0;
				}
				while(b1>=a1&&b2>=a2) {
					int len = (b1-a1)+1+(b2-a2)+1;
					if(arr1[m1]>arr2[m2]) {
						//b1 = m1+m2+1-a1-a2> (len%2==0? ? m1-1:m1;
						a2 = m1+m2-a1-a2<len/2-1 ? m2+1:m2;
					}else if(arr1[m1]<arr2[m2]) {
						a1 = m1+m2-a1-a2<len/2-1 ? m1+1:m1;
						b2 = m1+m2+1-a1-a2>len/2 ? m2-1:m2;
					}else {
						if(arr1.length%2==1) {
							return arr1[m1];
						}else {
							return arr1[m1+1]<arr2[m2+1]?(arr1[m1]+arr1[m1+1])/2.0:(arr2[m2]+arr2[m2+1])/2.0;
						}
						
					}
					if(b1==a1&&b2==a2) {
						if(arr1[a1]==arr2[a2])return arr1[a1];
						int small = Math.min(arr1[a1], arr2[a2]);
						
						if(small==arr1[a1]) {
                            if(a1+1>=arr1.length)return (arr1[a1]+arr2[a2])/2.0;
                            int posSmall = arr1[a1+1];
							return posSmall<arr2[a2]?(small+posSmall)/2.0:(arr1[a1]+arr2[a2])/2.0;
						}else {
                            if(a2+1>=arr2.length)return (arr1[a1]+arr2[a2])/2.0;
                            int posSmall = arr2[a2+1];
							return posSmall<arr1[a1]?(small+posSmall)/2.0:(arr1[a1]+arr2[a2])/2.0;
						}
					}
					m1 = a1+((b1-a1)>>1);
					m2 = a2+((b2-a2)>>1);
				}
				if(b1==a1)return (arr1[b1]+arr1[b1+1])/2.0;
				return (arr2[b2]+arr2[b2+1])/2.0;
			}
		}else if(arr1!=null&&arr1.length>0) {
			return arr1.length%2==0?(arr1[arr1.length/2]+arr1[arr1.length/2-1])/2.0:arr1[arr1.length/2];
		}else if(arr2!=null&&arr2.length>0) {
			return arr2.length%2==0?(arr2[arr2.length/2]+arr2[arr2.length/2-1])/2.0:arr2[arr2.length/2];
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] arr1 = {3};
		int[] arr2 = {1,2,4};
		double ans = findMedian(arr1, arr2);
		System.out.println(ans);
	}

}
