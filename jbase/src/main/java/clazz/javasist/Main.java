package clazz.javasist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Function:  TODO
 * <p>
 * author     San Mo
 * version    V1.0
 * Date:      2019/8/31 18:58
 */
public class Main {

    public static void main(String[] args) throws Exception {

        ClassPool cp = ClassPool.getDefault();

        CtClass ctClass = cp.get("clazz.javasist.Clazz");


        CtClass cc = cp.makeInterface("Tester");
            Class<?> c = cc.toClass();

        ctClass.addInterface(ctClass);

        ClassLoader classLoader1 = Main.class.getClassLoader();

        ClassLoader classLoader = c.getClassLoader();
            Class<?> tester = Class.forName("Tester", true,classLoader);



            System.out.println();

    }

}
