package string;

public class Length {


    public static void main(String[] args) {
        String str="012345.6789";
        int index = str.indexOf('.');
        System.out.println(str.substring(0,index));
        System.out.println(str.substring(index+1,str.length()));
    }

}
