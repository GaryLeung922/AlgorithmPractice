package cn.xiaojiaqi.sword2Offer;

public class Solution13 {
	public static int MoreThanHalfNum_Solution(int [] array) {
		if(array!=null&&array.length>0){
			int candy = array[0];
			int hp = 1;
			for(int i=1;i<array.length;i++){
				if(array[i]==candy&&hp>0){
					hp++;
				}else if(array[i]!=candy&&hp>0){
					hp--;
				}else{
					candy = array[i];
					hp = 1;
				}
			}
			int count = 0;
			for(int i=0;i<array.length;i++){
				if(array[i]==candy){
					count++;
				}
			}
			return count>array.length/2 ? candy : 0;
		}
		return 0;
	}
	public static int MoreThanKNum_Solution(int [] array,int k) {
		if(array!=null&&array.length>0){
			int[] candy = new int[k-1];
			int[] hp = new int[k-1];
			int candys = 0;
			for(int i=0;i<array.length;) {
				for(int j=0;j<k-1;j++,i++) {
					
				}
			}
		}
		return 0;
	}

	
	
}
