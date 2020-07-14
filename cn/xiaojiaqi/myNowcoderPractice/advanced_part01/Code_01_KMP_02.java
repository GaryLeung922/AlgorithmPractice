package cn.xiaojiaqi.myNowcoderPractice.advanced_part01;

import cn.xiaojiaqi.common.TestUtil;

import java.util.Arrays;

/**
 * @Author: liangjiaqi
 * @Date: 2020/7/6 10:02 PM
 */
public class Code_01_KMP_02 {


    public int indexOf(String s1,String s2){
        if(s1==null||s2==null||s1.length()<s2.length())return -1;

        int[] next = nextArr(s2);
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int a = 0;
        int b = 0;
        int c = 0;
        while(c<=s1.length()-s2.length()){
            if(a>=s1.length()||b>=s2.length())return c;

            if(c1[a]==c2[b]){
                a++;
                b++;
            }else{
                if(next[b]<0){
                    c++;
                    a = c;
                    b = 0;
                }else{
                    c = a - next[b];
                    b = next[b];
                }

            }
        }
        return -1;
    }

    /**
     * next数组
     * @param s1
     * @return
     */
    public int[] nextArr(String s1){
        char[] chars = s1.toCharArray();

        int[] next = new int[chars.length];
        next[0] = -1;
        next[1] = 0;

        int i=2;
        int cur = next[i-1];
        while(i<next.length){
            if(cur>=0){
                if(chars[cur]==chars[i-1]){
                    next[i++] = ++cur;
                }else{
                    cur = next[cur];
                }
            }else {
                next[i++] = 0;
                cur = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        Code_01_KMP_02 c  = new Code_01_KMP_02();
        String arr = "abcabcca";

        int[] ints = c.nextArr(arr);
        System.out.println(Arrays.toString(ints));

        String s1 = "abcdef";
        String s2 = "cd";

        int index = c.indexOf(s1, s2);
        System.out.println(index);
        for(int i=0;i<99999;i++){
            String s11 = TestUtil.generateStr(10,false);
            String s22 = TestUtil.generateStr(2,false);

            if(c.indexOf(s11,s22)!=s11.indexOf(s22)){
                System.out.println(s11);
                System.out.println(s22);
                System.out.println(c.indexOf(s11,s22));
                System.out.println(s11.indexOf(s22));
                break;
            }
        }
        System.out.println("BINGO!");

    }
}
