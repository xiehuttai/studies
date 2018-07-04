package spi;


import spi.service.Bye;
import spi.service.Hello;

import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {

        ServiceLoader<Hello> hellos = ServiceLoader.load(Hello.class);
        for (Hello h:hellos)
            System.out.println(h.say());

        ServiceLoader<Bye> byes = ServiceLoader.load(Bye.class);

        for (Bye b:byes)
            System.out.println(b.sayBye());
    }
}
