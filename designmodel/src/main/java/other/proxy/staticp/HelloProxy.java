package other.proxy.staticp;

public class HelloProxy implements Hello {

    Hello hello;

    public HelloProxy(Hello hello) {
        this.hello = hello;
    }

    @Override
    public void sayHi() {
        before();
        hello.sayHi();
        after();
    }

    public void before(){
        System.out.println("before.");
    }

    public void after(){
        System.out.println("after.");
    }
}
