package proxy.staticp;

public class Main {

    public static void main(String[] args) {

        Hello hello = new HelloProxy(new HelloImpl());

        hello.sayHi();

    }

}
