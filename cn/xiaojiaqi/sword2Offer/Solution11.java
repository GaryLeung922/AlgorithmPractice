package cn.xiaojiaqi.sword2Offer;
public class Solution11 {
    public int FirstNotRepeatingChar(String str) {
        if(str!=null&&str.length()>0){
            long res = 0;
            long one = 1;
            for(int i=0;i<str.length();i++){
                int bit = str.charAt(i)-'A'<26 ? str.charAt(i)-'A' : str.charAt(i)-'a'+26;
                res = isBit(res,bit);
            }
            for(int i=0;i<str.length();i++){
                int bit = str.charAt(i)-'A'<26 ? str.charAt(i)-'A' : str.charAt(i)-'a'+26;
                if(((res>>bit)&one)==0){
                    return i;
                }
            }
        } 
        return -1;
        
    }
    public long isBit(long res,int n){
    	long one = 1;
        if(((res>>n)&one)==0){
            res|=(1<<n);
        }
        return res;
    }
}