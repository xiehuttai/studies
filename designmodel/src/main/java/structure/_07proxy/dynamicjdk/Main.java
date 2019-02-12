package structure._07proxy.dynamicjdk;

public class Main {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        DynamicProxy dynamicProxy = new DynamicProxy();

        Hello proxy = (Hello)dynamicProxy.getProxy(hello);
        proxy.sayHi();
    }
}
