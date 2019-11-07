package string;

public class Length {


    public static void main(String[] args) {
        String str="012345.6789";

        int index = str.indexOf('.');
        // index=6
        System.out.println(String.format("index=%s",index));
        // 012345
        System.out.println(str.substring(0,index));
        // 6789
        System.out.println(str.substring(index+1,str.length()));

    }

}
