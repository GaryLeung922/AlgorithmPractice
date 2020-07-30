package cn.xiaojiaqi.oj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author: liangjiaqi
 * @Date: 2020/7/27 10:46 PM
 */
public class Main03 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int j = s.nextInt();
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++){
            matrix[i][i] = 1;
        }
        for(int i=0;i<j;i++){
            int v = s.nextInt();
            int u = s.nextInt();
            matrix[u-1][v-1] = 1;
            matrix[v-1][u-1] = 1;
        }
        int begin = s.nextInt() - 1;
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Item> queue = new LinkedList<>();
        queue.offer(new Item(begin,0));
        map.put(begin,0);
        while(!queue.isEmpty()){
            Item item = queue.poll();
            for(int i=0;i<n;i++){
                if(i!=item.node && matrix[item.node][i]!=0){
                    if(map.containsKey(i))continue;
                    queue.offer(new Item(i,item.latency+1));
                    map.put(i,item.latency+1);
                }
            }
        }
        int max = 0;
        Object[] array = map.values().toArray();
        for(int i=0;i<array.length;i++){
            if(max < (int)array[i]){
                max = (int)array[i];
            }
        }
        System.out.println(max*2);

    }
    static class Item{
        public Integer node;
        public Integer latency;

        public Item(Integer node, Integer latency) {
            this.node = node;
            this.latency = latency;
        }
    }
}
