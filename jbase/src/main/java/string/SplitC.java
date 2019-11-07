package string;

/**
 * Function:  TODO
 * <p>
 * author     San Mo
 * version    V1.0
 * Date:      2019/10/26 10:51
 */
public class SplitC {

    public static void main(String[] args) {

        // amqp://userName:password@hostName:portNumber/virtualHost
        String url ="amqp://userName:password@hostName:portNumber/virtualHost";
        String protocol = "amqp://";
        String colon = ":";
        String at = "@";
        String slash="/";

        int i0 = url.indexOf(protocol)+protocol.length();
        int i1 = url.indexOf(colon,i0);
        System.out.println(url.substring(i0,i1));

        int i2 = url.indexOf(at,i1);
        System.out.println(url.substring(i1+colon.length(),i2));

        int i3 = url.indexOf(colon,i2);
        System.out.println(url.substring(i2+at.length(),i3));

        int i4 = url.indexOf(slash,i3);
        System.out.println(url.substring(i3+colon.length(),i4));

        System.out.println(url.substring(i4+slash.length()));
    }
}
