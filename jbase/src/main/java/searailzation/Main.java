package searailzation;

import com.alibaba.fastjson.JSON;

/**
 * Function:  验证能否把父类属性序列化
 * <p>
 * author     San Mo
 * version    V1.0
 * Date:      2019/9/11 20:52
 */
public class Main {


    public static void main(String[] args) {

        B b = new B();

        b.setA(0);
        b.setB(1);

        System.out.println(JSON.toJSONString(b));

    }

}
