package structure.proxy.dynamicjdk;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        DynamicProxy dynamicProxy = new DynamicProxy();

        Hello proxy = (Hello)dynamicProxy.getProxy(hello);
        proxy.sayHi();
    }
}
