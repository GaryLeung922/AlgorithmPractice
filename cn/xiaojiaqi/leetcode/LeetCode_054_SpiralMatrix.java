package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 旋转打印矩阵
 * @Author: liangjiaqi
 * @Date: 2020/10/2 10:15 AM
 */
public class LeetCode_054_SpiralMatrix {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            if(matrix==null || matrix.length==0)return Collections.emptyList();
            int n = matrix.length;
            int m = matrix[0].length;
            List<Integer> res = new ArrayList<>(n*m);
            help(matrix, 0,0,n-1,m-1, res);
            return res;
        }

        private void help(int[][] matrix, int ar, int ac, int br, int bc, List<Integer> res){
            if(ar>br || ac>bc)return;


            // 1. print up row
            for(int i=ac; i< bc;i++){
                res.add(matrix[ar][i]);
            }
            // handle just one row;
            if(ar==br){
                res.add(matrix[br][bc]);
                return;
            }

            // 2. print right column
            for(int i=ar; i< br; i++){
                res.add(matrix[i][bc]);
            }
            // handle just one column;
            if(ac==bc){
                res.add(matrix[br][bc]);
                return;
            }

            //3. print down row
            for(int i=bc;i>ac;i--){
                res.add(matrix[br][i]);
            }

            // 4. print left column
            for(int i=br;i>ar;i--){
                res.add(matrix[i][ac]);
            }
            help(matrix, ar+1, ar+1, br-1,bc-1,res);
        }
    }
}
