package exception;

/**
 * ClassName: ExceptionTest
 * Function:  TODO
 * author     San Mo
 * version    V1.0
 * Date:      2019/7/15 10:15
 */
public class ExceptionTest {

    static {
        /**
         * 运行时异常，
         */
        Integer.parseInt("1");
        /**
         * 普通异常一定要catch，不然编译都通过不了。
         */
//       throw new Exception("");
    }

    /**
     * 运行时异常可以不捕获
     * @param code
     * @return
     */
    public static int get(int code) throws NoSuchMethodException {
        if (code == 0)
            throw new IllegalArgumentException();
        if (code<0){
            throw new NoSuchMethodException();
        }
        return 0;
    }

}
