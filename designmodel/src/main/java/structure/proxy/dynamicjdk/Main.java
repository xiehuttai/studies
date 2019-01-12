package structure.proxy.dynamicjdk;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(hello);

        Hello proxyInstance = (Hello)Proxy.newProxyInstance(hello.getClass().getClassLoader(),
                hello.getClass().getInterfaces(), dynamicProxy);
        proxyInstance.sayHi();

        Hello proxy = (Hello)dynamicProxy.getProxy();
        proxy.sayHi();
    }
}
