package create.singleton;


/**
 * 线程安全，饿汉模式, volatile + 双重检测
 */
public class Singleton4 {

    private Singleton4(){
    }

    private volatile static Singleton4 instance=null;

    public static Singleton4 getInstance(){
        if (instance==null)
            synchronized (Singleton4.class){
                if (instance==null)
                instance=new Singleton4();
            }
        return instance;
    }

}
