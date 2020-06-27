package cn.xiaojiaqi.leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1115. Print FooBar Alternately
 * 两个线程A，B分别同时执行foo(),bar(),要求foobarfoobar顺序交替输出
 * @Author: liangjiaqi
 * @Date: 2020/6/26 3:15 PM
 */
public class LeetCode_1115_Print_FooBar_Alternately {

    private int n;

    Semaphore f = new Semaphore(0);
    Semaphore b = new Semaphore(1);

    public LeetCode_1115_Print_FooBar_Alternately(int n) {
        this.n = n;
    }


    /**
     * 方案一：基于信号量Semaphore
     * @param printFoo
     * @throws InterruptedException
     */
    public void foo1(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            b.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            f.release();
        }
    }

    public void bar1(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            f.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            b.release();
        }
    }


    /**
     * 方案二：基于一个信号量+一个CyclicBarrier
     * @param printFoo
     * @throws InterruptedException
     */
    private Semaphore foo = new Semaphore(0);
    private CyclicBarrier c = new CyclicBarrier(2);
    public void foo2(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                c.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            printFoo.run();
            foo.release();
        }
    }

    public void bar2(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                c.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            foo.acquire();
            printBar.run();
        }
    }


    /**
     * 方案三： 基于一个状态变量
     */
    volatile boolean permitFoo = true;

    public void foo3(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; ) {
            if(permitFoo) {
                printFoo.run();
                i++;
                permitFoo = false;
            }
        }
    }

    public void bar3(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; ) {
            if(!permitFoo) {
                printBar.run();
                i++;
                permitFoo = true;
            }
        }
    }

    public static void main(String[] args) {

        LeetCode_1115_Print_FooBar_Alternately c = new LeetCode_1115_Print_FooBar_Alternately(5);
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.print("foo");
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.print("bar");
            }
        };


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.foo3(r1);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.bar3(r2);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();

    }

}
