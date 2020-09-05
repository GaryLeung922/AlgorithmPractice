package cn.xiaojiaqi.leetcode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/2 12:28 PM
 */
public class LeetCode_010_RegularExpressionMatching {


    /**
     * 暴力递归
     */
    static class Solution {
        public boolean isMatch(String s, String p) {
            if(s==null||p==null)return false;
            return isMatch(p,s,0,0);

        }

        public boolean isMatch(String s, String p, int i, int j){
            if(i==s.length()&&j==p.length())return true;
            // s="c*c*" , p=""
            if(j>=p.length() && s.length()>i+1 && s.charAt(i+1)=='*'){
                return s.length()-1==i+1 ? true : isMatch("",s.substring(i+2));
            }
            if(i>=s.length() || j>=p.length())return false;
            if(i+1<s.length() && s.charAt(i+1)=='*'){
                if(s.charAt(i)!=p.charAt(j) && s.charAt(i)!='.'){
                    return isMatch(s,p,i+2,j);
                }else if(s.charAt(i)=='.'){
                    if(j==p.length()-1){
                        return i+2 == s.length()||isMatch(s,p,i+2,j) || isMatch(s,p,i,j+1);
                    }
                    return isMatch(s,p,i+2,j) || isMatch(s,p,i,j+1);
                }else {
                    if(j==p.length()-1){
                        return i+2 == s.length()|| isMatch(s,p,i+2,j) || isMatch(s,p,i,j+1);
                    }
                    return isMatch(s,p,i+2,j) || isMatch(s,p,i,j+1);
                }
            }else if(s.charAt(i)==p.charAt(j) || s.charAt(i)=='.'){
                return isMatch(s,p,i+1,j+1);
            }else{
                return false;
            }
        }
    }

    /**
     * DP 解法，一切可以暴力递归的都可以转化为DP
     */
    static class Solution2 {
        public boolean isMatch(String s, String p) {
            if(s==null||p==null)return false;

            //dp[i][j] 表示：p[0..i-1] 能否匹配s[0..j-1]
            boolean[][] dp = new boolean[p.length()+1][s.length()+1];
            // 代表两者都为空""， 那么可以匹配
            dp[0][0] = true;
            // 处理情况：s="",p="c*c*"
            for(int i=1;i<dp.length;i++){
                if(i%2==0){
                    if(p.charAt(i-1)=='*'){
                        dp[i][0] = true;
                    }else {
                        break;
                    }
                }
            }

            for(int i=1;i<dp.length;i++){
                for(int j=1;j<dp[0].length;j++){
                    // p[i-1]=='*'
                    if(p.charAt(i-1)=='*'){
                        // p[i-2]!=s[j-1] 那么* 只能为0，即丢弃掉前一个字符，去看p[0..i-3]与s[0..j-1]是否匹配
                        if(p.charAt(i-2)!=s.charAt(j-1) && p.charAt(i-2)!='.'){
                            dp[i][j] = dp[i-2][j];

                        //如果p[i-2]=='.'或者p[i-2]==s[j-1]，那么
                        //1. 既可以去看p[0..i-3]与s[0..j-1]是否匹配 （*作为0）
                        //2. 也可以看p[0..i-1]与s[0..j-2]是否匹配 （*作为1，2，3...）
                        }else if(p.charAt(i-2)=='.'){
                            dp[i][j] = dp[i-2][j] || dp[i][j-1];
                        }else {
                            dp[i][j] = dp[i-2][j] || dp[i][j-1];
                        }

                    // 如果p[i-1]==s[j-1] 或者 p[i-1]=='.' 那么去看p[0..i-1]与s[0..j-2]继续匹配
                    }else if(p.charAt(i-1)==s.charAt(j-1) || p.charAt(i-1)=='.'){
                        dp[i][j] = dp[i-1][j-1];

                    // p[0..i-1]与s[0..j-1]不匹配，为false
                    }else{
                        dp[i][j] = false;
                    }
                }
            }

            return dp[dp.length-1][dp[0].length-1];

        }


    }

    public static void main(String[] args) {
        String s = ""; // "aa"
        String p = "c*c*"; //"a*"

        Solution solution = new Solution();
        boolean match = solution.isMatch(s, p);
        System.out.println(match);

        Solution2 solution2 = new Solution2();
        boolean match1 = solution2.isMatch(s, p);
        System.out.println(match1);
    }
}
