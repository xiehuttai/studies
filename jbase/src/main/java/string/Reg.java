package string;

public class Reg {

    public static void main(String[] args) {

        String path="classpath*:application.xml";
        String[] split = path.split("[,\\s]+");

        System.out.println(split.length);
        System.out.println(split[0]);

    }

}
