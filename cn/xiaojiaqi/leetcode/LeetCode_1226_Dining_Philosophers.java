package cn.xiaojiaqi.leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 哲学家问题：
 * 关键在于避免死锁：
 * 死锁产生的4个必要条件：
 * （1）互斥条件：一个资源每次只能被一个进程使用。
 * （2）占有且等待：进程已经占有了至少一个资源，同时请求新资源而被阻塞时，对已获得的资源保持不放。
 * （3）不可强行占有:进程已获得的资源，在末使用完之前，不能强行剥夺。
 * （4）循环等待条件:若干进程之间形成一种头尾相接的循环等待资源关系。
 *
 * 我们只需要破坏其中一个条件就可以了。例如可以破坏循环等待条件。
 * 1. 先拿左手叉子，再拿右手叉子。如果右手叉子被人拿了，则释放左手叉子。两个叉子同时拿到才可以进食
 * 2. 给叉子编号0-5，每个人都是先拿序号小的叉子，再拿序号大的叉子
 * 3.（提醒：5个哲学家被编号为0-4) 可以让编号为奇数的哲学家先拿左边的叉子，再拿右边的叉子。
 *      编号为偶数的哲学家则按照相反的顺序，先拿右边的叉子，再拿左边的叉子。
 * 4.只允许最多四个哲学家同时进餐，以保证至少有一个哲学家能够进餐。例如用 Semaphore 实现：Semaphore eatLimit = new Semaphore(4); 每次哲学家要拿叉子前，先调用 eatLimit.acquire()，然后再申请叉子对应的锁。
 *
 * https://leetcode-cn.com/problems/the-dining-philosophers/solution/san-chong-si-lu-po-pi-xun-huan-deng-dai-by-ngcafai/
 * https://blog.csdn.net/Yun_Ge/article/details/89177918
 * @Author: liangjiaqi
 * @Date: 2020/6/27 5:54 PM
 */
public class LeetCode_1226_Dining_Philosophers {
}

/**
 * 解法一： 五个信号两个代表五个叉子。 破坏死锁尝试方法1
 */
class DiningPhilosophers1 {

    private Semaphore one = new Semaphore(1);
    private Semaphore two = new Semaphore(1);
    private Semaphore three = new Semaphore(1);
    private Semaphore fore = new Semaphore(1);
    private Semaphore five = new Semaphore(1);

    public DiningPhilosophers1() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        while(true){
            switch(philosopher){
                case 0:
                    five.acquire();
                    if(one.tryAcquire()){
                        pickLeftFork.run();
                        pickRightFork.run();
                        eat.run();
                        putLeftFork.run();
                        five.release();
                        putRightFork.run();
                        one.release();
                        return;
                    }else{
                        five.release();
                    }
                    break;
                case 1:
                    one.acquire();
                    if(two.tryAcquire()){
                        pickLeftFork.run();
                        pickRightFork.run();
                        eat.run();
                        putLeftFork.run();
                        one.release();
                        putRightFork.run();
                        two.release();
                        return;
                    }else{
                        one.release();
                    }
                    break;
                case 2:
                    two.acquire();
                    if(three.tryAcquire()){
                        pickLeftFork.run();
                        pickRightFork.run();
                        eat.run();
                        putLeftFork.run();
                        two.release();
                        putRightFork.run();
                        three.release();
                        return;
                    }else{
                        two.release();
                    }
                    break;
                case 3:
                    three.acquire();
                    if(fore.tryAcquire()){
                        pickLeftFork.run();
                        pickRightFork.run();
                        eat.run();
                        putLeftFork.run();
                        three.release();
                        putRightFork.run();
                        fore.release();
                        return;
                    }else{
                        three.release();
                    }
                    break;
                case 4:
                    fore.acquire();
                    if(five.tryAcquire()){
                        pickLeftFork.run();
                        pickRightFork.run();
                        eat.run();
                        putLeftFork.run();
                        fore.release();
                        putRightFork.run();
                        five.release();
                        return;
                    }else{
                        fore.release();
                    }
                    break;

            }
        }


    }

}

/**
 * 解法二：破坏死锁，尝试方法2
 */
class DiningPhilosophers2{
     ReentrantLock[] forks = new ReentrantLock[5];

     public DiningPhilosophers2() {
         for (int i = 0; i < forks.length; i++) {
             forks[i] = new ReentrantLock();
         }
     }

     // call the run() method of any runnable to execute its code
     public void wantsToEat(int philosopher,
                            Runnable pickLeftFork,
                            Runnable pickRightFork,
                            Runnable eat,
                            Runnable putLeftFork,
                            Runnable putRightFork) throws InterruptedException {

         int fork1 = philosopher;
         int fork2 = (philosopher + 1) % 5;

         forks[Math.min(fork1, fork2)].lock();
         forks[Math.max(fork1, fork2)].lock();
         pickLeftFork.run();
         pickRightFork.run();
         eat.run();
         putLeftFork.run();
         putRightFork.run();
         forks[Math.min(fork1, fork2)].unlock();
         forks[Math.max(fork1, fork2)].unlock();
     }
}

/**
 * 解法三：破坏死锁，尝试方法3
 */
class DiningPhilosophers3 {

    volatile Semaphore[] forks = new Semaphore[]{
            new Semaphore(1)
            , new Semaphore(1)
            , new Semaphore(1)
            , new Semaphore(1)
            , new Semaphore(1)
    };

    public DiningPhilosophers3() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        // philosopher 表示哲学家的 index 号

        int leftForkNo = philosopher;
        int rightForkNo = (philosopher + 1) % 5;

        if (philosopher % 2 == 0) {
            forks[leftForkNo].acquire();
            forks[rightForkNo].acquire();
        } else {
            forks[rightForkNo].acquire();
            forks[leftForkNo].acquire();
        }

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        putRightFork.run();

        forks[leftForkNo].release();
        forks[rightForkNo].release();
    }
}
