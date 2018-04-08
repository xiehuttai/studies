package cas;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private AtomicInteger atomicI = new AtomicInteger(0);
    private volatile int i=0;

    public static void main(String[] args){
        final Main cas = new Main();
        ArrayList<Thread> threads = new ArrayList<Thread>(600);
        long start = System.currentTimeMillis();
        for (int j= 0;j<100;j++){
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        cas.count();
                        cas.safeCount();
                    }
                }
            });
            threads.add(thread);
        }

        for (Thread t:threads) {
            t.start();
        }

        for (Thread t: threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(cas.i);
        System.out.println(cas.atomicI.get());
        System.out.println(System.currentTimeMillis()-start);

    }

    private void safeCount(){
        for (;;){
            int i= atomicI.get();
            boolean suc =atomicI.compareAndSet(i,++i);
            if (suc){
                break;
            }
        }
    }

    private void count(){
        ++i;
    }

}
