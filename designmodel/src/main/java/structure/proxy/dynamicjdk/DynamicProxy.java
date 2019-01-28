package structure.proxy.dynamicjdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy() {

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    private void after() {
        System.out.println("after.");
    }

    private void before() {
        System.out.println("before.");
    }


    /**
     * 简化使用
     * @return
     */
    public Object getProxy(Object target){
        this.target = target;
        Class<?> aClass = target.getClass();
        return Proxy.
                newProxyInstance(aClass.getClassLoader(),
                        aClass.getInterfaces(),
                        this);
    }


}
