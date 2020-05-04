package cn.xiaojiaqi.leetcode;
public class LeetCode_42_Trapping_Rain_Water {
    //解法1.单调栈
    //可以用，求解一个数组中，左右邻近且大于其的元素的思路。
//     public int trap(int[] height) {
//         if(height==null||height.length<3)return 0;
        
//         Stack<Integer> minStack = new Stack<>();
//         int water = 0;
//         for(int i=0;i<height.length;i++){
//             if(minStack.isEmpty()||height[minStack.peek()]>height[i]){
//                 minStack.push(i);
//             }else if(height[minStack.peek()]<height[i]){
//                 while(!minStack.isEmpty()&&height[minStack.peek()]<height[i]){
//                     int cur = height[minStack.pop()];
//                     if(minStack.isEmpty()){//栈中无元素，说明改元素左边不存在大于其的元素
//                         break;
//                     }else if(height[minStack.peek()]>cur){
//                         int left = minStack.peek();//左边最近且大于其的元素
//                         water+=(Math.min(height[i],height[left])-cur)*(i-left-1);
//                     }
//                 }
//                 minStack.push(i);
//             }else {//如果相等，则保留后一个
//             	minStack.pop();
//             	minStack.push(i);
//             }
//         }
//         return water;
//     }
    
    //解法2：DP（先存储各个位置的左边最大值，右边最大值信息）
    
//     public int trap(int[] height) {
//         if(height==null||height.length<3)return 0;
        
//         int[] lMax = new int[height.length];
//         int[] rMax = new int[height.length];
        
//         int water = 0;
//         lMax[0] = height[0];
//         rMax[height.length-1] = height[height.length-1];
//         for(int i=1;i<height.length;i++){
//             lMax[i] = Math.max(lMax[i-1],height[i]);
//         }
//         for(int i=height.length-2;i>=0;i--){
//             rMax[i] = Math.max(rMax[i+1],height[i]);
//         }
//         for(int i=0;i<height.length;i++){
//             int min = Math.min(lMax[i],rMax[i]);
//             if(height[i]<min){
//                water+=(min-height[i]); 
//             }
//         }
//         return water;
//     }
    
    //解法3：双指针
    
    public int trap(int[] height) {
        if(height==null||height.length<3)return 0;
        
        int left = 0;
        int right = height.length-1;
        int left_max = 0;
        int right_max = 0;
        int ans = 0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>=left_max){
                    left_max = height[left];
                }else{
                    ans+=(left_max-height[left]);
                }
                left++;
            }else{
                if(height[right]>=right_max){
                    right_max = height[right];
                }else{
                    ans+=(right_max-height[right]);
                }
                right--;
            }
        }
        return ans;
    }
}