package var;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        var list = new ArrayList<String>();
        var scl = ClassLoader.getSystemClassLoader();

        System.out.printf("list "+list + "\n" +
                "scl "+ scl);

    }

}
