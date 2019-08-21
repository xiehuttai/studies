import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        //线程
        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("Runnable thread");
            }
        }).start();

        new Thread(()-> System.out.println("lamda thread")).start();


        //map集合
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("k1", "v1");
        hashMap.put("k2", "v2");

        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println(" for " +entry.getKey()+":"+entry.getValue());
        }

        hashMap.forEach((k, v) -> System.out.println("lamda " +k + ":" + v));

    }
}
