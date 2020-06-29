package cn.xiaojiaqi.leetcode;

/**
 *
 * https://leetcode-cn.com/problems/gas-station/solution/jia-you-zhan-by-leetcode/
 * @Author: liangjiaqi
 * @Date: 2020/6/29 1:22 PM
 */
public class LeetCode_134_Gas_Station {

//    1.If car starts at A and can not reach B. Any station between A and B can not reach B.(B is the first station that A can not reach.)
//    2.If the total number of gas is bigger than the total number of cost. There must be a solution.

    static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            if(gas==null||cost==null||gas.length!=cost.length)return -1;

            int curTank = gas[0]-cost[0];
            int start = 0;
            int cur=1%cost.length;
            while(cur!=start){
                if(curTank<0){
                    // if start>cur, the journey is impossible.
                    if(start > cur)return -1;
                    start = cur;
                    curTank = gas[start]-cost[start];

                }else{
                    curTank+=(gas[cur]-cost[cur]);
                }
                cur = (cur+1)%cost.length;
            }

            //
            return curTank>=0 ? start : -1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] gas = new int[]{1,2,3,4,3,2,4,1,5,3,2,4};
        int[] cost = new int[]{1,1,1,3,2,4,3,6,7,4,3,1};

        int circuit = s.canCompleteCircuit(gas, cost);
        System.out.println(circuit);
    }
}
