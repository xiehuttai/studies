package create.singleton;


/**
 * 线程安全，饿汉模式
 */
public class Singleton2 {

    private Singleton2(){
    }

    private static Singleton2 instance= new Singleton2();

    public static Singleton2 getInstance(){

        return instance;
    }

}
