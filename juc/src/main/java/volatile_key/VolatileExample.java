package volatile_key;

public class VolatileExample {

    int a=0;
    volatile boolean flag = false;
//    boolean flag = false;

    public void writer(){
        a=2;
        flag=true;
    }

    public void reader(){
        if (flag){
            int i= a*a;
            System.out.println(i);
        }
    }

}
