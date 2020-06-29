package cn.xiaojiaqi.leetcode;

/**
 * @Author: Gary Leung
 * @Date: 6/29/20 11:18 PM
 */
public class LeetCode_275_H_Index_2 {
    /**
     * 二分查找。 翻版，查找第一个大于target或者小于target的
     */
    class Solution {
        public int hIndex(int[] citations) {
            if(citations==null || citations.length==0){
                return 0;
            }
            return bs(citations,0,citations.length-1);

        }

        public int bs(int[] citation,int i,int j){
            if(i==j){
                if(citation[i]>=(citation.length-i)){
                    return citation.length-i;
                }else{
                    return citation.length-(i+1);
                }
            }
            if(i>j)return (citation.length-i);
            int m = i+(j-i)/2;

            if(citation[m]>=(citation.length-m)){
                return bs(citation,i,m-1);
            }else{
                return bs(citation,m+1,j);
            }

        }
    }
}
