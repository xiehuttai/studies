package json;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;

/**
 * Function:  TODO
 * <p>
 * author     San Mo
 * version    V1.0
 * Date:      2019/10/24 08:59
 */
public class Main {


    public static void main(String[] args) throws UnsupportedEncodingException {

        String x="xxxxx";

        byte[] y= "yyyyyy".getBytes();


        A a = new A();
        a.setX(x);
        a.setY(y);

        String str = JSON.toJSONString(a);

        System.out.println(str);

        A obj = JSON.parseObject(str, A.class);


        System.out.println(String.format("x=%s,y=%s",obj.x,new String(obj.y,"UTF-8")) );


    }


}


class A{

    String x;

    byte[] y;

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public byte[] getY() {
        return y;
    }

    public void setY(byte[] y) {
        this.y = y;
    }
}