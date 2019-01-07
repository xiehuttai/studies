package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {
        //实例化一个CountDownLatch对象
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        //创建一个线程t1
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("进入线程t1  等待其他线程处理完成……");
                    countDownLatch.await();
                    System.out.println("t1线程继续执行……");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        },"t1").start();
        //创建一个线程t2
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("进入线程t2进行初始化操作……");
                    Thread.sleep(5000);
                    System.out.println("t2线程执行完毕。。。");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        },"t2").start();
        //创建一个线程t3
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("进入线程t3进行初始化操作……");
                    Thread.sleep(4000);
                    System.out.println("t3线程执行完毕。。。");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        },"t3").start();
    }
}