package cn.xiaojiaqi.oj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: liangjiaqi
 * @Date: 2020/7/27 12:49 PM
 */
public class HJ106_reverse_words {
    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//
//        int n = s.nextInt();
//        String[] strs = new String[n];
//        for(int i=0;i<n;i++){
//            strs[i] = s.next();
//        }
//        Arrays.sort(strs);
//        System.out.println(Arrays.toString(strs));
//
//        String str = "asdff";
//        str.split(",");
        String a = "a";
        String b = "A";
        System.out.println(a.compareTo(b));
        System.out.println(String.valueOf('a'));
        System.out.println(String.valueOf('b'));
        System.out.println(String.valueOf('a').compareTo(String.valueOf('A')));

        String[] aa = new String[]{"a","A","B","b"};
        Arrays.sort(aa);
        System.out.println(Arrays.toString(aa));

    }
}
