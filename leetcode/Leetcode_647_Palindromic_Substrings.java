package cn.xiaojiaqi.leetcode;
/**
 * manacher 算法相关
 * @author Narut0
 *
 */
public class Leetcode_647_Palindromic_Substrings {
    //manacher算法求parr数组
    public int countSubstrings(String s) {
        if(s==null||s.length()==0)return 0;
        
        int count = 0;
        char[] sch = manacherString(s);
        int[] parr = new int[sch.length];
        int R = -1;
        int C = -1;
        
        for(int i=0;i<sch.length;i++){
            parr[i] = i>R  ? 1 : Math.min(R-i+1,parr[2*C-i]);
            while(i+parr[i]<sch.length&&i-parr[i]>-1){
                if(sch[i+parr[i]]==sch[i-parr[i]]){
                    parr[i]++;
                }else{
                    break;
                }
            }
            if(i+parr[i]-1>R){
                R = i+parr[i]-1;
                C = i;
            }
            //#a#a#a#a#a#   字符串
            //12345654321   parr
            //01122322110   以当前位置为轴，可以贡献的回文子串
            count+=parr[i]/2;
        }
        return count;
        
        
        
    }
    public char[] manacherString(String s){
        StringBuilder sb = new StringBuilder("#");
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i)+"#");
        }
        return sb.toString().toCharArray();
    }
}