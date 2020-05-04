package cn.xiaojiaqi.leetcode;

public class Solution32 {
	//对于每个i开头(一定包括)的子串，看看它最远能扩到哪？
	//
    public static int longestValidParentheses1(String s) {
        if(s==null&&s.length()==0)return 0;
        char[] chs = s.toCharArray();
        int max = 0;
        int cursum=0;
        
        int begin = s.indexOf("(", 0);
        if(begin==-1)return 0;
        while(begin<=chs.length-2) {
        	int end = f(chs, begin);
        	System.out.println(begin+"--"+end);
        	if(end==-1) {
        		cursum = 0;
        		begin++;
        	}else {
        		cursum = cursum+(end-begin+1);
        		max = Math.max(max, cursum);
        		begin=end+1;
        	}
        }
        return max;
        //System.out.println(Arrays.toString(res));
        
    }
    public static int f(char[] chs,int begin){
        if(begin>=chs.length||chs[begin]==')') return -1;
        begin++;
        while(begin<chs.length&&chs[begin]=='(') {
        	int end = f(chs, begin);
        	if(end!=-1) {
        		begin=end+1;
        	}else {
        		return -1;
        	}
        }
        if(begin>=chs.length) {
        	return -1;
        }else {
        	return begin;
        }
        
    }
    //DP  
    public static int longestValidParentheses2(String s) {
        if(s==null||s.length()<=1)return 0;
        char[] chs = s.toCharArray();
        int max = 0;
        int cursum=0;
        int[] dp = new int[s.length()];
        //dp[i]:表示以i开头的有效括号最长能到哪？ 若dp[i]=i，说明扩不动；dp[i]>i，则[i,dp[i]]为有效子串
        dp[dp.length-1]=dp.length-1;
        for(int i=dp.length-2;i>-1;i--) {
        	if(chs[i]==')') {
        		dp[i]=i;
        	}else {
        		int begin = i+1;
        		while(begin<dp.length&&dp[begin]!=begin) {
        			begin = dp[begin]+1;
        		}
        		//begin==dp.length说明没有右括号;chs[begin]=='('保证有效子串结尾字符必须为右括号
        		dp[i]= begin==dp.length||chs[begin]=='(' ? i : begin;
        		
        	}
        }
        int i=0;
        while(i<dp.length) {
        	if(dp[i]==i) {
        		i++;
        		//若中间出现断档，重新计算累加和
        		cursum=0;
        	}else {
        		cursum+=(dp[i]-i+1);
        		max = Math.max(max, cursum);
        		i=dp[i]+1;
        	}
        }
        return max;
        
    }
    public static void main(String[] args) {
		String s = "(()";
		int ans = longestValidParentheses2(s);
		System.out.println(ans);
	}
}