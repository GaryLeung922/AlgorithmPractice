package cn.xiaojiaqi.leetcode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @Author: liangjiaqi
 * @Date: 2020/6/27 4:11 PM
 */
public class LeetCode_1195_Fizz_Buzz {
}

/**
 * 解法一： volatile + lock + DCL
 */
class FizzBuzz1 {
    private int n;
    private volatile int count=1;
    private Lock lock = new ReentrantLock();

    public FizzBuzz1(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(count<=n){
            lock.lock();

            try{
                // DCL double check
                if(count>n)return;

                if(count%3==0&&count%5!=0){
                    printFizz.run();
                    count++;
                }
            }finally{
                lock.unlock();
            }

        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(count<=n){
            lock.lock();
            try{
                if(count>n)return;

                if(count%5==0&&count%3!=0){
                    printBuzz.run();
                    count++;
                }
            }finally{
                lock.unlock();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(count<=n){
            lock.lock();

            try{
                if(count>n)return;
                if(count%5==0&&count%3==0){
                    printFizzBuzz.run();
                    count++;
                }
            }finally{
                lock.unlock();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(count<=n){
            lock.lock();
            try{
                if(count>n)return;

                if(count%5!=0&&count%3!=0){
                    printNumber.accept(count);
                    count++;
                }
            }finally{
                lock.unlock();
            }

        }
    }
}

/**
 * 解法二：synchronized + notify
 */
class FizzBuzz2 {
    private int n;
    private volatile int count=1;

    public FizzBuzz2(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while(count<=n){
            if(count%3==0&&count%5!=0){
                printFizz.run();
                count++;
                this.notifyAll();
            }else{
                this.wait();
            }

        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while(count<=n){
            if(count%5==0&&count%3!=0){
                printBuzz.run();
                count++;
                this.notifyAll();
            }else{
                this.wait();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(count<=n){
            if(count%5==0&&count%3==0){
                printFizzBuzz.run();
                count++;
                this.notifyAll();
            }else{
                this.wait();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while(count<=n){

            if(count%5!=0&&count%3!=0){
                printNumber.accept(count);
                count++;
                this.notifyAll();
            }else{
                this.wait();
            }
        }
    }
}

