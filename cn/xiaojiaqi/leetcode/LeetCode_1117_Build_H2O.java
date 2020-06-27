package cn.xiaojiaqi.leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1117. Building H2O
 * @Author: liangjiaqi
 * @Date: 2020/6/27 11:40 AM
 */
public class LeetCode_1117_Build_H2O {
    private  int state = 0;
    private Lock lock = new ReentrantLock();
    private Condition c = lock.newCondition();
    public LeetCode_1117_Build_H2O() {

    }

    /**
     * 解法一： 状态变量+锁同步
     *
     * 状态不对 -> while中无限wait
     * @param releaseHydrogen
     * @throws InterruptedException
     */
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        lock.lock();
        try{
            while(state!=0 && state!=1 && state!=3 && state!=4){
                c.await();

            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            state = state==3 ? 0 : (state==4 ? 3 : state+1);
            c.signal();
        }finally{
            lock.unlock();
        }


    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        lock.lock();
        try{
            while(state!=0&&state!=1&&state!=2){
                c.await();
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            state = state==0 ? 4 :(state==1 ? 3 : 0);
            c.signal();
        }finally{
            lock.unlock();
        }

    }

    private Semaphore h = new Semaphore(2);
    private Semaphore o = new Semaphore(0);

    public void hydrogen2(Runnable releaseHydrogen) throws InterruptedException {


        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        h.acquire();
        releaseHydrogen.run();
        if(h.availablePermits()==0){
            o.release();
        }
    }

    public void oxygen2(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        o.acquire();
        releaseOxygen.run();
        h.release(2);

    }



}

/**
 * 解法三： 两个信号量+CyclicBarrier
 */
class H2O {

    private Semaphore h = new Semaphore(2);
    private Semaphore o = new Semaphore(1);
    private CyclicBarrier c = new CyclicBarrier(3);
    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {


        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        h.acquire();
        try {
            c.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        releaseHydrogen.run();
        h.release();

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        o.acquire();
        try {
            c.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        releaseOxygen.run();
        o.release();

    }
}