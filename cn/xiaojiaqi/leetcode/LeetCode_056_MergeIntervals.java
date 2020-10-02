package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * @Author: liangjiaqi
 * @Date: 2020/9/29 10:08 AM
 */
public class LeetCode_056_MergeIntervals {
    /**
     * 先排序后合并
     */
    class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals==null || intervals.length<=1)return intervals;

            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0]<o2[0]){
                        return -1;
                    }else if(o1[0]>o2[0]){
                        return 1;
                    }else{
                        if(o1[1]<o2[1]){
                            return -1;
                        }else if(o1[1]>o2[1]){
                            return 1;
                        }else {
                            return 0;
                        }
                    }
                }
            });

            List<int[]> list = new ArrayList<>();
            int[] pre = intervals[0];
            for(int i=1;i<intervals.length;i++){
                int[] cur = intervals[i];
                if(cur[0]<=pre[1]){
                    pre[1] = Math.max(cur[1],pre[1]);
                }else{
                    list.add(pre);
                    pre = cur;
                }
            }
            list.add(pre);
            int[][] res = new int[list.size()][2];
            for(int i=0;i<res.length;i++){
                res[i] = list.get(i);
            }
            return res;
        }
    }
}
