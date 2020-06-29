package cn.xiaojiaqi.leetcode;

import java.util.Arrays;

/**
 * @Author: Gary Leung
 * @Date: 6/29/20 9:40 PM
 */
public class LeetCode_274_H_Index {

    /**
     * 解法一： 暴力，先排序，再计算h
     * 对于排序后的i位置，如果citations[i]>=(citations.length-i)
     * 时间O(nlogn) 空间O(1)
     */
    class Solution {
        public int hIndex(int[] citations) {
            if(citations==null || citations.length==0){
                return 0;
            }

            Arrays.sort(citations);

            int h = citations.length;
            for(int i=0;i<citations.length;i++){
                if(citations[i]>=h){
                    return h;
                }
                h--;
            }
            return h;

        }
    }

    /**
     * 解法二：计数排序，
     * 时间O(N) ,空间O(N)
     */
    class Solution2 {
        public int hIndex(int[] citations) {
            if(citations==null || citations.length==0){
                return 0;
            }

            int[] p = new int[citations.length+1];
            //把大于citations.length 全部计算到citations.length 桶里
            for(int i=0;i<citations.length;i++){
                if(citations[i]>citations.length){
                    citations[i] = citations.length;
                }
                p[citations[i]]++;
            }

            int h = citations.length;
            int s = 0;
            for(int j=p.length-1;j>=0;j--){
                s+=p[j];
                if(s>=h){
                    return h;
                }
                h--;
            }
            return h;

        }
    }
}
