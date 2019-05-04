package cn.xiaojiaqi.test;
public class Solution15 {
    public static boolean isContinuous(int [] numbers) {
        if(numbers!=null&&numbers.length==5){
            int[] hash = new int[14];
            for(int i=0;i<5;i++){
                if(numbers[i]!=0&&hash[numbers[i]]!=0){
                    return false;
                }else{
                    hash[numbers[i]]++;
                }
            }
            int zeros = hash[0];
            boolean flag = false;
            int continuous = 0;
            for(int i=1;i<14;i++){
                if(hash[i]==1&&flag==false){
                	continuous++;
                    flag = true;
                }else if(hash[i]!=1&&flag==true){
                    if(--zeros <0&&continuous!=5){
                        return false;
                    }else if(continuous==5){
                    	return true;
                    }
                    continuous++;
                }else if (hash[i]==1&&flag==true) {
					continuous++;
				}
            }
            return true;
                
        }
        return false;
    }
    public static void main(String[] args) {
		int[] arr = {1,3,2,5,4};
		boolean fl = isContinuous(arr);
		System.out.println(fl);
	}
}