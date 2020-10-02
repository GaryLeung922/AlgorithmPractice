package cn.xiaojiaqi.oj;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: liangjiaqi
 * @Date: 2020/8/26 4:03 PM
 */
public class Test {

    public static void main(String args[]) {
//        int[] arr = {110, 67, 111, 95, 98, 115, 118};
//
//        int i = countGroupAgeMoreThanHalf(arr);
//        System.out.println(i);
//
//        // 思路正确  结果正确    没有判空异常处理  结果错误 有判空处理 非最佳解法 api使用有问题 代码不规范 代码有bug
//        // 思路正确 结果错误
//

//        int[] nums = {2, 1, -2, 3};
//        int target = 5;
//        System.out.println(closestNumber(nums, target));
//
//        nums = new int[]{2, 1, -9, 15};
//        System.out.println(closestNumber(nums, target));
//
//        int W = 3;
//        int[][] R = {{0,1,600},{1,2,800},{0,2,1300}};
//        int A = 0;
//        int B = 2;
//
//        System.out.println(findAirTicketPrice(W,R,A,B));
//
//        R = new int[][]{{0,1,600},{1,2,500},{0,2,1300}};
//
//        System.out.println(findAirTicketPrice(W,R,A,B));

        String cardNo = "1A2w3e4r";
        String res = "123465119101114";

        String s = CardNoConvert(cardNo);
        System.out.println(s);

        String ss = "1,2,6,1,0,16";
        int k =2;
        int maxProfit = maxProfit(k, ss);
        System.out.println(maxProfit);

    }

    public static String findNum(String cardNo){
        String cardNum = "";
        String[] str = cardNo.split("");
        for(int i = 0; i < str.length; i++){
            if(str[i].matches("[0-9]+")){
                cardNum = cardNum + str[i];
            }
        }
        return cardNum;
    }
    public static int maxProfit(int k, String str) {
        int res = 0;

        return  res;
    }
    static int dfs(int[] input, int index, int status, int time, int k){
        if(index==input.length||time==k) return 0;
        int none,buy = 0,sell = 0;
        none = dfs(input,index+1,status,time,k);
        if(status==1) sell = dfs(input,index+1,0,time+1,k)+input[index];
        else buy = dfs(input,index+1,1,time,k)-input[index];
        return Math.max(Math.max(none,buy),sell);
    }

    public static String findChar(String cardNo){
        String cardChar = "";
        String[] str = cardNo.split("");
        for(int i = 0; i < str.length; i++){
            if(str[i].matches(".[a-z][A-Z] + .")){
                byte byteAscii = (byte)str[i].toCharArray()[0];
                cardChar = cardChar + byteAscii;
            }
        }
        return cardChar;
    }

    public static String CardNoConvert(String cardNo){
        String findNum = findNum(cardNo);
        String findChar = findChar(cardNo);
        return (findNum + findChar);
    }


    public static int findAirTicketPrice(int W,int[][] R,int A,int B){
        return 0;
    }
    static class Ticket{

        int to;
        int distance;
        public Ticket(int t, int d) {

            to = t;
            distance = d;
        }
    }

    public static int dfs(List<Node>[] list, int from, int to, int sum, boolean[] visited) {
        int res = Integer.MAX_VALUE;
        for (Node cur: list[from]) {
            if (cur.city == to) {
                res = Math.min(res, sum + cur.price);
            } else {
                visited[from] = true;
                if (visited[cur.city] == false) {
                    res = Math.min(res, dfs(list, cur.city, to, sum + cur.price, visited));
                }
            }
        }
        return res;
    }


    static class Node {
        int city;
        int price;
        public Node(int city, int price) {
            this.city = city;
            this.price = price;
        }
    }

    public static int findMinAirTicketPrice(int W, int[][] R, int A, int B) {
        int[][] graph = new int[W][W];
        for (int[] r : R) {
            graph[r[0]][r[1]] = r[2];
        }
        boolean[] visited = new boolean[W];
        int[] minCost = {Integer.MAX_VALUE};
        findMinAirTicketPrice(graph, visited, A, B, minCost, 0);
        return minCost[0] == Integer.MAX_VALUE ? -1 : minCost[0];
    }
    public static int findMinAirTicketPriceDP(int W, int[][] R, int A, int B) {
        int[][] graph = new int[W][W];
        for (int[] r : R) {
            graph[r[0]][r[1]] = r[2];
        }
        int[] dp = new int[W];
        dp[A] = 0;






        return  0;
    }

    public static void findMinAirTicketPrice(int[][] R, boolean[] visited,
                                             int A, int B, int[] minCost, int cost) {
        if (A == B) {
            if (minCost[0] > cost) {
                minCost[0] = cost;
            }
        }
        for (int i = 0; i < R.length; ++i) {
            if (R[A][i] != 0 && !visited[i]) {
                visited[i] = true;
                findMinAirTicketPrice(R, visited, i, B,
                        minCost, cost + R[A][i]);
                visited[i] = false;
            }
        }
    }
    public static int closestNumber(int[] nums,int target){
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length-2;i++){
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(ans > Math.abs(sum - target)){
                    ans = Math.abs(sum - target);
                    res = sum;
                }
                if(ans == 0){
                    return target;
                }
                if(sum - target > 0){
                    end--;
                }else{
                    start++;
                }
            }
        }
        return res;
    }

    public static int countGroupAgeMoreThanHalf(int[] a){
        int count = 1;
        int left = 0;
        int right = 1;
        int length = a.length;
        while(left<=length-count){
            int target = a[left];
            right = left+1;
            while(right<length){
                if(a[right]>target){
                    target = a[right];
                    continue;
                }else{
                    break;
                }
            }
            if((right-left)>count){
                count = right-left;
            }
            left = right;
        }
        return count;
    }
}
