package other.proxy.dynamiccglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private static CglibProxy instance=new CglibProxy();

    private CglibProxy(){
    }

    public static CglibProxy getInstance(){
        return instance;
    }

    public <T> T getProxy(Class<T> cls){
        return (T)Enhancer.create(cls,this);
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        before();
        Object result = proxy.invokeSuper(obj, args);
        after();
        return result;
    }

    private void after() {
        System.out.println("after");
    }

    private void before() {
        System.out.println("before");
    }

}
