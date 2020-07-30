package cn.xiaojiaqi.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: liangjiaqi
 * @Date: 2020/7/27 10:04 PM
 */
public class Main02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        int n = s.nextInt();

        char[] chars = str.toCharArray();

        char cur = chars[0];
        char count = 1;
        List<Item> array = new ArrayList<>();
        for(int i=1;i<chars.length;i++){
            if(chars[i]==chars[i-1]){
                count++;
            }else{
                    array.add(new Item(cur,count));
                cur = chars[i];
                count = 1;
            }
        }
        array.add(new Item(cur,count));

        array.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.count - o1.count;
            }
        });
        int res = -1;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<array.size();i++){
            if(set.contains(array.get(i).c)){
                continue;
            }else{
                n--;
                set.add(array.get(i).c);
                if(n==0){
                    res = array.get(i).count;
                    break;
                }
            }
        }
        System.out.println(res);



    }
    static class Item implements Comparable<Item>{
        public char c;
        public int count;

        public Item(char c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public int compareTo(Item o) {
            return o.count - this.count;
        }

        @Override
        public String toString() {
            return this.c+":"+this.count;
        }
    }
}
