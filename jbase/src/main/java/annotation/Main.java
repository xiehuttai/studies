package annotation;

import annotation.anno.Person;
import annotation.anno.Put;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {

        Person person = new Person();

        Field[] fields = person.getClass().getFields();
        for (Field f : fields) {
            boolean annotationPresent = f.isAnnotationPresent(Put.class);
            if (annotationPresent){
                Put annotation = f.getAnnotation(Put.class);
                if (annotation !=null && annotation instanceof  Put){
                    int value = annotation.value();
                    f.setAccessible(true);
                    if (annotation.isId()) {
                        f.setInt(person,value);
                    }else {
                        f.set(person,annotation.name());
                    }
                }
            }
        }

        Method[] methods = person.getClass().getMethods();
        for (Method m: methods){
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a:annotations) {
                if (a instanceof Put){
                     m.invoke(person, ((Put) a).desc());
                }
            }
        }

        System.out.println(person.id);
        System.out.println(person.name);

    }

}
