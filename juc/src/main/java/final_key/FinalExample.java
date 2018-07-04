package final_key;

public class FinalExample {

    int i;
    final int j;

    static FinalExample obj;

    public FinalExample() {
        i = 1;
        j = 2;
    }

    public static void writer(){
        obj= new FinalExample();
    }

    public static void reader(){
        FinalExample object = obj;
        int a=object.i;
        int b=object.j;

        System.out.println(a);
        System.out.println(b);
    }
}
