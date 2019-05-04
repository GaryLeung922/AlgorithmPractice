package cn.xiaojiaqi.test;

public class Solution4 {
    public String LeftRotateString(String str,int n) {
        if(str!=null&&str.length()>0&&n>=0){
            int len = str.length();
            n%=len;
            char[] ctr = str.toCharArray();
            for(int i=0;i<=len/2;i++){
                swap(ctr,i,len-1-i);
            }
            for(int i=0;i<(len-n)/2;i++){
                swap(ctr,i,(len-n)-1-i);
            }
            for(int i=(len-n);i<(len-n)+n/2;i++){
                swap(ctr,i,len-1-(i-len+n));
            }
            StringBuilder strb = new StringBuilder();
            for(int i=0;i<len;i++) {
            	strb.append(ctr[i]);
            }
            
            return new String(strb);
        }
        return "";
    }
    public void swap(char[] ctr,int a,int b){
        char tmp = ctr[a];
        ctr[a] = ctr[b];
        ctr[b] = tmp;
    }
    public static void main(String[] args) {
		Solution4 solution4 = new Solution4();
		String str = "abcdefg";
		String newStr = solution4.LeftRotateString(str, 2);
		System.out.println(newStr);
	}
}