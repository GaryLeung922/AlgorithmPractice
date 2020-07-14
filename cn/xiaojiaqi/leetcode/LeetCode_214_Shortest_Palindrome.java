package cn.xiaojiaqi.leetcode;

/**
 * @Author: liangjiaqi
 * @Date: 2020/7/14 8:11 AM
 */
public class LeetCode_214_Shortest_Palindrome {

    class Solution {
        // just find the most right position whose left palindrome bound's index is 0;
        public String shortestPalindrome(String s) {
            String string = replaceStr(s);
            char[] chars = string.toCharArray();
            int[] p = new int[string.length()];
            int L = 0;
            int R = 0;
            int c = 0;
            int cur = 1;
            int mostIndex=0;
            while(R < p.length-1){
                if(cur>=R){
                    int mostRight = mostRight(chars, cur, cur+1);
                    if(mostRight>R){
                        R = mostRight;
                        L = cur - (mostRight-cur);
                        c = cur;
                        if(L==0){
                            mostIndex = cur;
                        }
                    }
                    p[cur] = mostRight-cur;
                }else{
                    int scur = c - (cur-c);
                    if(scur - p[scur] > L){
                        p[cur] = p[scur];
                    }else if(scur - p[scur] < L){
                        p[cur] = scur-L;
                    }else {
                        int mostRight = mostRight(chars, cur, R+1);
                        if(mostRight>R){
                            R = mostRight;
                            L = cur - (mostRight-cur);
                            c = cur;
                            if(L==0){
                                mostIndex = cur;
                            }
                        }
                        p[cur] = mostRight-cur;
                    }
                }
                cur++;
            }
            String revert = string.substring(mostIndex+p[mostIndex]+1);
            StringBuilder sb = new StringBuilder();
            char[] re = revert.toCharArray();
            for(int i=re.length-1;i>=0;i--){
                sb.append(re[i]);
            }
            sb.append(string);

            return sb.toString().replaceAll("#","");
        }

        // brute extend
        public int mostRight(char[] chars, int i, int m){
            int n = i-(m-i);
            while(m<chars.length && n>=0){
                if(chars[n] == chars[m]){
                    n--;
                    m++;
                }else{
                    break;
                }
            }
            return m-1;
        }

        public String replaceStr(String str){
            char[] cs = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(char c : cs){
                sb.append('#');
                sb.append(c);
            }
            sb.append('#');
            return sb.toString();
        }
    }
}
