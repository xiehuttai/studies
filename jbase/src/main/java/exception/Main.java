package exception;

import java.util.concurrent.TimeUnit;

/**
 * ClassName: Main
 * Function:  TODO
 * author     San Mo
 * version    V1.0
 * Date:      2019/7/15 10:14
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            ExceptionTest exceptionTest = new ExceptionTest();
        }).start();

//        try {
//            ExceptionTest.get(0);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }

        try {
            ExceptionTest.get(-1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

//        TimeUnit.SECONDS.sleep(11);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
