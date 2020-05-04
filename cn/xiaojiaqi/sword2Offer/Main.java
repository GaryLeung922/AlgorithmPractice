package cn.xiaojiaqi.sword2Offer;

/**
 * 题目描述
输入一个ip地址串，判断是否合法。
输入描述:
每行有一个IP地址，IP地址的形式为a.b.c.d，其中a、b、c、d都是整数。
输出描述:
可能有多组测试数据，对于每组数据，如果IP地址合法则输出"Yes!”，否则输出"No!”。

合法的IP地址为：
a、b、c、d都是0-255的整数。
 */
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            String[] strs = str.split("\\.");
            boolean flag = true;
            for(String s:strs){
                if(!isValid(s)){
                    
                    flag = false;
                    break;
                }
            }
            System.out.println(flag ? "Yes!" : "No!");
        }
    }
    public static boolean isValid(String str){
        try{
            if(str.length()>3||(str.charAt(0)=='0'&&str.length()>1)){
                return false;
            }
            if(Integer.parseInt(str)<=255&&Integer.parseInt(str)>=0)return true;
             
             return false;
        }catch(Exception e){
            return false;
        }
    }
    
}