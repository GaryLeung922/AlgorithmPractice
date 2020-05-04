package cn.xiaojiaqi.sword2Offer;
/**
 * 算法 12322121343434 1232212134343*4 必须插入五个星号，每个数字必须在0-600之间，有几种插入方法
 * @author Narut0
 *
 */
public class Solution66 {

	public static int ways1(String str,int n) {
		if(str.length()<n+1)return 0;
		
		return helper1(str,0,1,n);
	}
	//求合法的ip种类,对于19216801，则有三种
	public static int ways2(String str) {
		if(str.length()<3+1)return 0;
		
		return helper2(str,0,1,3);
	}
	private static int helper1(String str, int lastBegin, int cur, int nums) {
		if(nums==0)return Integer.parseInt(str.substring(lastBegin))<=600 ? 1:0;
		if(cur>=str.length())return 0;
		
		int ans = 0;
		String part = str.substring(lastBegin, cur);
		//System.out.println(part);
		while(Integer.parseInt(part)<=600) {
			ans+=helper1(str, cur, cur+1, nums-1);
			cur++;
			if(cur>=str.length())break;
			part = str.substring(lastBegin, cur);
		}
		return ans;
		
	}
	private static int helper2(String str, int lastBegin, int cur, int nums) {
		if(nums==0) {
			return isValid(str.substring(lastBegin)) ? 1 : 0;
		}
		if(cur>=str.length())return 0;
		
		int ans = 0;
		String part = str.substring(lastBegin, cur);
		//System.out.println(part);
		while(isValid(part)) {
			ans+=helper2(str, cur, cur+1, nums-1);
			cur++;
			if(cur>=str.length())break;
			part = str.substring(lastBegin, cur);
		}
		return ans;
		
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
	public static void main(String[] args) {
		String str = "1111112";
		
		int ans = ways1(str, 5);
		System.out.println(ans);
		
		int ans2 = ways2("19216801");
		System.out.println(ans2);
		
		System.out.println(isValid("01"));
	}
	

}
