package cn.xiaojiaqi.leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A,B,C三个线程并发执行，按顺序依次交替打印ABC
 * 详细题解： https://zhuanlan.zhihu.com/p/81626432
 * @Author: liangjiaqi
 * @Date: 2020/6/26 4:30 PM
 */
public class Muti_Thread_ABC {
    public static volatile int flag = 0;
    public static void main(String[] args) {
        solution3();
    }

    public static Lock lock = new ReentrantLock();
    public static Condition c = lock.newCondition();

    /**
     * 方案三：两个信号量+一个CyclicBarrier
     */
    public static Semaphore a = new Semaphore(0);
    public static Semaphore b = new Semaphore(0);
    public static CyclicBarrier cc = new CyclicBarrier(3);
    public static void solution3(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try {
                        cc.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.print("A");
                    a.release();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++) {
                    try {
                        cc.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    try {
                        a.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("B");
                    b.release();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++) {
                    try {
                        cc.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    try {
                        b.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("C");

                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }


    /**
     * 解法二：
     * 通过volatile,无锁编程实现顺序交替打印
     */
    public static void solution2(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;){
                    if(flag==0){
                        System.out.print("A");
                        i++;
                        flag =1;
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;) {
                    if(flag==1){
                        System.out.print("B");
                        i++;
                        flag =2;
                    }
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;) {
                    if(flag==2){
                        System.out.println("C");
                        i++;
                        flag=0;
                    }
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }

    /**
     * 解法一： 使用信号量同步
     */
    public static void solution1(){
        Semaphore s1 = new Semaphore(0);
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(1);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try {
                        s3.acquire();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("A");
                    s1.release();

                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++) {
                    try {
                        s1.acquire();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("B");
                    s2.release();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++) {
                    try {
                        s2.acquire();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("C");
                    s3.release();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
