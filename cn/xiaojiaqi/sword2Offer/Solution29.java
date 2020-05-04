package cn.xiaojiaqi.sword2Offer;

public class Solution29 {
    public double Power(double base, int exponent) {
        double res = 1.0;
        double cur = base;
        int n;
        if(exponent<0){
            if(base==0){
                throw new RuntimeException("分母不能为0！");
            }
            n = -exponent;
        }else if(exponent==0){
            return 1.0;
        }else{
            n = exponent;
        }
        while(n>0){
            if((n&1)==1){
                res*=cur;
            }
            cur*=cur;
            n>>=1;
        }
        return exponent>0?res:(1/res);
  }
}