package cn.xiaojiaqi.oj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: liangjiaqi
 * @Date: 2020/7/27 9:20 PM
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (s.hasNext()){
            String str = s.next();
            char[] chars = str.toCharArray();

            long[] count = new long[52];

            for(int i=0;i<chars.length;i++){
                if(chars[i]>=97){
                    count[chars[i]-97]++;
                }else{
                    count[chars[i]-65+25]++;
                }
            }

            List<Item> array = new ArrayList<>();
            for(int i=0;i<52;i++){
                if(count[i]>0){
                    if(i<=25){
                        array.add(new Item((char)(i+97),count[i]));
                    }else{
                        array.add(new Item((char)(i-25+65),count[i]));
                    }
                }

            }
            array.sort(new Comparator<Item>() {
                @Override
                public int compare(Item o1, Item o2) {
                    if(o1.count==o2.count){
                        if(o1.c>=97 && o2.c <=90){
                            return -1;
                        }else if(o2.c>=97 && o1.c <=90){
                            return 1;
                        }else {
                            return o1.c - o2.c;
                        }
                    }
                    return  o2.count > o1.count ? 1 : -1;
                }
            });
            array.forEach(item -> {
                System.out.print(item+";");
            });
        }



    }
    static class Item{
        public char c;
        public long count;

        public Item(char c, long count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public String toString() {
            return c+":"+count;
        }
    }
}
