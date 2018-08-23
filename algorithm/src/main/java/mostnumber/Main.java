package mostnumber;

public class Main {

    public static void main(String[] args) {
        int[] array = {1,2,3,3,3,4,3,4,2,3,3,2};
        int result = moreThanHalf(array);
        System.out.println(result);
    }

    public static int moreThanHalf(int[] array  ){
        int result=array[0];
        int count=0;
        for (int i = 0; i < array.length; i++) {
            if (count==0){
                result=array[i];
                count++;
            }else {
                if (result==array[i])
                    count++;
                else count--;
            }
            System.out.print(count + " ");
        }
        return result;
    }
}
