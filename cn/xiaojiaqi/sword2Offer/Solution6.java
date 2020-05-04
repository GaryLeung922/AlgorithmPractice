package cn.xiaojiaqi.sword2Offer;

import java.util.HashSet;

public class Solution6 {
    public int GetNumberOfK(int [] array , int k) {
       if(array!=null&&array.length>0&&k>=array[0]&&k<=array[array.length-1]){
           int a = 0;
           int b = array.length-1;
           int mid = (a+b)/2;
           while(a<b&&array[mid]!=k){
               if(array[mid]<k){
            	   if(a==mid) {
            		   return 0;
            	   }
                   a = mid;
                   mid = (a+b)/2;
               }else{
            	   if(b==mid) {
            		   return 0;
            	   }
                   b = mid;
                   mid = (a+b)/2;
               }
           }
           if(array[mid]==k) {
        	   int left = mid;
        	   int right = mid;
        	   for(;left>=0;left--) {
        		   if(array[left]!=k) {
        			   break;
        		   }
        	   }
        	   for(;right<array.length;right++) {
        		   if(array[right]!=k) {
        			   break;
        		   }
        	   }
        	   return right-left-1;
           }else {
			return 0;
		}
       }
       return 0;
    }
    public static void main(String[] args) {
		int[] arr = {1,2,3,3,3,3,4,5,7};
		Solution6 solution6 = new Solution6();
		int res = solution6.GetNumberOfK(arr, 6);
		System.out.println(res);
		HashSet<Integer> set = new HashSet<>();
		set.add(3);
		set.add(4);
		
		Object[] arrr = set.toArray();
		System.out.println(arrr[1]);
		
    }
}