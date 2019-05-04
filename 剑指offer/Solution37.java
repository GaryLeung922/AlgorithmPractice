package cn.xiaojiaqi.test;
// write your code here
import java.util.Scanner;

public class Solution37{
    public static int[] parent(int n){
        if(n<1)return new int[0];
        int len = (int)Math.floor(Math.log((double)n)/Math.log(2.0));
        int[] res = new int[len];
        int i=0;
        while(n/2>=1){
            res[i++] = n/2;
            n /= 2;
        }
        return res;
    }
    public static int nearestParent(int[] res1,int[] res2){
        int i = res1.length-1;
        int j = res2.length-1;
        while(i>=0&&j>=0){
            if(res1[i]!=res2[j])return res1[i+1];
            i--;
            j--;
        }
        if(i==-1)return res1[0];
        if(j==-1)return res2[0];
        return 1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println((int)Math.pow(2, 3));
        String[] strs = new String[3];
        //if(strs[0].equals(""))System.out.println("yes");
        while(sc.hasNextLine()){
            int i = sc.nextInt();
            int j = sc.nextInt();
            System.out.println(nearestParent(parent(i),parent(j)));
        }
       
    }
    
}