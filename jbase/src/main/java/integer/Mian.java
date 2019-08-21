package integer;

public class Mian {

    public static void main(String[] args) {

        /**
         * compare(a,b) >1,=0,<-1
         */
        int compare10 = Integer.compare(1, 0);
        int compare11 = Integer.compare(1, 1);
        int compare12 = Integer.compare(1, 2);

        System.out.println(compare10);
        System.out.println(compare11);
        System.out.println(compare12);

        /**
         * JVM中一个字节以下的整型数据会在JVM启动的时候加载进内存，
         * 除非用new Integer()显式的创建对象，否则都是同一个对象。
         */

        Integer i01 = 59;
        int i02 = 59;
        Integer i03 =Integer.valueOf(59);
        Integer i04 = new Integer(59);

        System.out.println(i01==i02);
        System.out.println(i01==i03);
        System.out.println(i03==i04);

    }

}
