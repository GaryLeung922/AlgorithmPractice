package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution406 {
	public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0)
            return new int[0][0];
            
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });
        
        int n = people.length;
        ArrayList<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++)
            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});

        int[][] res = new int[people.length][2];
        int j = 0;
        for (int[] k : tmp) {
            res[j][0] = k[0];
            res[j++][1] = k[1];
        }
        
        return res;
    }
}