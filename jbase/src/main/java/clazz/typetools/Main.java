package clazz.typetools;

import net.jodah.typetools.TypeResolver;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Function:  typetools工具类
 * <p>
 * author     San Mo
 * version    V1.0
 * Date:      2019/8/21 14:39
 */

interface Foo<T> {}
class Bar implements Foo<List<Integer>> {}

public class Main {

    public static void main(String[] args) {

        Type typeArgs = TypeResolver.reify(Foo.class, Bar.class);

        ParameterizedType paramType = (ParameterizedType) typeArgs;
        Type[] actualTypeArgs = paramType.getActualTypeArguments();
        ParameterizedType arg = (ParameterizedType)actualTypeArgs[0];

        assert paramType.getRawType() == Foo.class;
        assert arg.getRawType() == List.class;
        assert arg.getActualTypeArguments()[0] == Integer.class;


    }

}
