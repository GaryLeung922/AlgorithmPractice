package cn.xiaojiaqi.leetcode;

/** 四键键盘
 * 假设你有一个特殊的键盘，键盘上有如下键:
 *
 * 键1: (A): 在屏幕上打印一个’A’。
 * 键2: (Ctrl-A): 选择整个屏幕。
 * 键3: (Ctrl-C): 复制选择到缓冲区。
 * 键4: (Ctrl-V): 在屏幕上已有的内容后面追加打印缓冲区的内容。
 * 现在，你只能按键盘上N次(使用以上四个键)，找出你可以在屏幕上打印的“A”的最大数量
 *
 * 样例
 * 1
 * 输入: 3
 * 输出: 3
 * 解释: A, A, A
 *
 * 2
 * 输入: 7
 * 输出: 9
 * 解释: A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
 *
 * 注意事项
 * 1 <= N <= 50
 * 答案将在32位有符号整数的范围内。
 *
 * @Author: liangjiaqi
 * @Date: 2020/9/5 9:20 AM
 */
public class LeetCode_651_4KeysKeyboard {
    static class Solution {
        public int fourKeysKeyboard(int n){
            return dp(n,0,0);
        }

        private int dp(int n, int buf, int cur){
            if(n==0){
                return 0;
            }
            int r1 = dp(n-1,buf,cur+1)+1;
            int r2 = dp(n-1,buf,cur+buf) + buf;
            int r3 = 0;
            if(n>=2){
                r3 = dp(n-2,buf+cur,cur);
            }
            return Math.max(Math.max(r1,r2),r3);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.fourKeysKeyboard(3);
        System.out.println(i);
    }
}
