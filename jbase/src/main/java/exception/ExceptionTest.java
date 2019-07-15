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
        Integer.parseInt("xx");
        /**
         * 普通异常一定要catch，不然编译都通过不了。
         */
//       throw new Exception("");
    }

}
