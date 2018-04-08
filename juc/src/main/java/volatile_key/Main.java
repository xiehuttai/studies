package volatile_key;

public class Main {

    public  static void main(String[] args){

        VolatileExample v = new VolatileExample();
        new WThread(v).start();
        new RThread(v).start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(v.a);
        System.out.println(v.flag);
    }
}
