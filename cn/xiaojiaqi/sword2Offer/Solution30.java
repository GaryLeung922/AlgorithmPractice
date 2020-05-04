package cn.xiaojiaqi.sword2Offer;
import java.util.ArrayList;
import java.util.Arrays;
public class Solution30 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> arr = new ArrayList<>();
        if(str!=null&&str.length()>0){
        	char[] ctr = str.toCharArray();
        	Arrays.sort(ctr);
            str = String.copyValueOf(ctr);
            process(str,"",arr);
        }
        return arr;
    }
    public void process(String str,String begin,ArrayList<String> arr){
        if(str.length()==0){
            arr.add(begin);
            return;
        }else{
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                String left = str.substring(0,i);
                String right = str.substring(i+1);
                process(left+right,begin+ch,arr);
            }
        }
    }
}