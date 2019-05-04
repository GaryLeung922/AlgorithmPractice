package cn.xiaojiaqi.test;
public class Solution18 {
    public static int Add(int num1,int num2) {
        int a;
        int b;
        int res=0;
        int sum=0;
        for(int i=0;i<32;i++){
            a = (num1>>i)&1;
            b = (num2>>i)&1;
            if(a==1&&b==1&&res==0){
                res = 1;
                sum|=(0<<i);
            }else if(a==1&&b==1&&res==1){
                res = 1;
                sum|=(1<<i);
            }else if((a==1||b==1) &&res==1){
                sum|=(0<<i);
            }else if((a==1||b==1) &&res==0){
                sum|=(1<<i);
            }else{
                sum|=(res<<i);
                res = 0;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
		int res = Add(1, 2);
		System.out.println(res);
	}
}