package cn.xiaojiaqi.sword2Offer;
import java.util.Arrays;
import java.util.Comparator;

public class Solution31 {
    public String PrintMinNumber(int [] numbers) {
        if(numbers!=null&&numbers.length>0){
            String[] strs = new String[numbers.length];
            for(int i=0;i<numbers.length;i++){
                strs[i]  = String.valueOf(numbers[i]);
            }
            Arrays.sort(strs,new MyComparator());
            String res = "";
            for(String str:strs) {
            	res+=str;
            }
            
            return res;
        }
        return "";
    }
    public static class MyComparator implements Comparator<String>{
        public int compare(String o1, String o2) {
			
			return (o1+o2).compareTo(o2+o1);
		}
    }
}
