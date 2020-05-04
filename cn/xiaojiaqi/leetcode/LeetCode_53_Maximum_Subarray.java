package cn.xiaojiaqi.leetcode;
public class LeetCode_53_Maximum_Subarray {
    public int maxSubArray(int[] arr) {
        if(arr==null||arr.length==0)return 0;
        
        int max = arr[0];
        int sum = arr[0];
        for(int i=1;i<arr.length;i++){
            if(sum+arr[i]>=arr[i]){//若大于，则sum更新
                sum+=arr[i];
                max = Math.max(max,sum);
            }else{//若不大于，则sum等于当前数
                sum = arr[i];
                max = Math.max(max,sum);
            }
        }
        max = Math.max(max,sum);
        return max;
    }
}