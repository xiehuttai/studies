package strman;

public class Main {

    public static void main(String[] args) {

        String s = Strman.rightPad("111", "*", 20);
        String s1 = Strman.leftPad(s, "*", 40);

        Strman.isEnclosedBetween("xx", "yy", "z");

        System.out.println(s);
        System.out.println(s1);


    }
}
