package string;

public class Main {

    public static void main(String[] args) {

        //1 no-heap
        String a = "abc";

        //1 no-heap
        String b = "abc";

        //2 heap
        String c = new String("abc");

        //1 no-heap
        String d = c.intern();

        //3 heap
        String e = new String("abc");

        System.out.println(a==b);
        System.out.println(b==c);
        System.out.println(c==d);
        System.out.println(c==e);
        System.out.println(a==d);

    }

}
