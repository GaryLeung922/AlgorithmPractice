package cn.xiaojiaqi.test;

import java.util.ArrayList;

public class Solution8 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> alist = new ArrayList<>();
        if(array!=null&&array.length>0){
            for(int i=0;i<array.length;i++){
                int k = getK(array,i+1,array.length-1,sum-array[i]);
                if(k!=-1){
                    alist.add(array[i]);
                    alist.add(array[k]);
                    return alist;
                }
            }
        }
        return alist;
        
    }
    public int getK(int[] arr,int left,int right,int k){
        if(left>right){
            return -1;
        }
        int mid = (left+right)/2;
        if(arr[mid]>k){
            return getK(arr,left,mid-1,k);
        }else if(arr[mid]<k){
            return getK(arr,mid+1,right,k);
        }else{
            return mid;
        }
    }
}