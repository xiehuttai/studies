package create.singleton;


/**
 * 线程安全，enum实现
 */
public class Singleton5 {

    private Singleton5(){
    }

    enum Singleton{

        INSTACNE;

        private Singleton5 singleton;

        Singleton(){
            singleton= new Singleton5();
        }

        public Singleton5 getSingleton(){
            return singleton;
        }
    }

    public static void main(String[] args) {
        Singleton.INSTACNE.getSingleton();
    }

}
