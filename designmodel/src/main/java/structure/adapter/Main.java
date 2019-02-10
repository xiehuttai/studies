package structure.adapter;

public class Main {

    public static void main(String[] args) {

        String password="password";
        Encipher encipher = new MD5Adapter();

        System.out.println(password);
        String encode = encipher.encode(password);
        System.out.println("encode:"+encode);

        String decode = encipher.decode(encode);
        System.out.println("decode:"+decode);

    }

}

/**
 * 适配者，加解密方法接口
 */
class MD5{

    String encode(String msg,int num){
        while (num>0){
            num--;
            msg=msg+".md5";
        }
        return msg;
    }

    String decode(String msg,int num){
        while (num>0){
            num--;
            msg=msg.substring(0,msg.length()-4);
        }
        return msg;
    }
}

/**
 * 使用接口，使用加节目的接口
 */
interface Encipher{
   String encode(String msg);
   String decode(String msg);
}

/**
 * 对象适配器
 */
class MD5Adapter implements Encipher{

    MD5 md5;

    public MD5Adapter() {
        this.md5 =  new MD5();
    }

    @Override
    public String encode(String msg) {
        return md5.encode(msg,1);
    }

    @Override
    public String decode(String msg ){
        return md5.decode(msg,1);
    }
}
