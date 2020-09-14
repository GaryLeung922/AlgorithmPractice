package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liangjiaqi
 * @Date: 2020/9/13 9:37 AM
 */
public class LeetCode_093_RestoreIPAddresses {
    static class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            if(s==null || s.length()==0)return res;
            help(s,0,1,"",res);
            return res;
        }

        private void help(String s, int start, int n, String ip, List<String> res){
            if(start>=s.length()){
                String ress = ip.substring(0,ip.length()-1);
                if(ress.split("\\.").length==4){
                    res.add(ress);
                }
                return;
            }

            if(n>4)return;

            // 剪枝： 剩下的数字长度不能超过(4-n)*3
            if(s.length()-start-1<=(4-n)*3){
                ip += (s.substring(start, start + 1) + ".");
                help(s, start + 1,n+1, ip, res);
                ip = ip.substring(0, ip.length() - 2);
            }
            // 不能以0开头
            if(s.charAt(start)=='0') return;

            //
            if(s.length()>=start+2 && s.length()-start-2<=(4-n)*3){
                ip+= (s.substring(start,start+2)+".");
                help(s,start+2,n+1,ip,res);
                ip = ip.substring(0,ip.length()-3);
            }

            if(s.length()>=start+3 && Integer.valueOf(s.substring(start,start+3))<=255 && s.length()-start-3<=(4-n)*3){
                ip += (s.substring(start, start+3)+".");
                help(s,start+3,n+1,ip,res);
                ip = ip.substring(0,ip.length()-4);
            }
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        Solution solution = new Solution();

        List<String> list = solution.restoreIpAddresses(s);
        System.out.println(list);


    }
}
