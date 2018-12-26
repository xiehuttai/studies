package other.proxy.dynamiccglib;


/**
 * 无需实现接口，对其中的方法进行拦截
 */
public class Main {

    public static void main(String[] args) {
        CglibProxy cglibProxy = CglibProxy.getInstance();
        HelloImpl proxy = cglibProxy.getProxy(HelloImpl.class);
        proxy.sayHi();
    }

}
