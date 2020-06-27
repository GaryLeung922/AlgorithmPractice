package cn.xiaojiaqi.leetcode;

import java.util.concurrent.Semaphore;

/**
 * @Author: liangjiaqi
 * @Date: 2020/6/27 3:38 PM
 */
public class LeetCode_1116_Print_Zero_Even_Odd {
    private int n;

    private Semaphore z = new Semaphore(1);
    private Semaphore e = new Semaphore(0);
    private Semaphore o = new Semaphore(0);
    public LeetCode_1116_Print_Zero_Even_Odd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero() throws InterruptedException {
        for(int i=0;i<n;i++){
            z.acquire();
            System.out.print(0);
            if(i%2==0){
                o.release();
            }else{
                e.release();
            }
        }


    }

    public void even() throws InterruptedException {
        for(int i=0;i<(n+1)/2;i++){
            e.acquire();
            System.out.print(2+i*2);
            z.release();
        }

    }

    public void odd() throws InterruptedException {
        for(int i=0;i<n/2;i++){
            o.acquire();
            System.out.print(1+i*2);
            z.release();
        }

    }

    public static void main(String[] args) {
        LeetCode_1116_Print_Zero_Even_Odd c = new LeetCode_1116_Print_Zero_Even_Odd(10);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.zero();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.odd();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.even();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }
}
