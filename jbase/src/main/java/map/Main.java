package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Function:  hashmap delete
 *
 * <p>
 * author     San Mo
 * version    V1.0
 * Date:      2019/11/7 10:50
 */
public class Main {


    public static void main(String[] args) {

        Map<Integer, Integer> map = new ConcurrentHashMap<>();
//        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);
        map.put(5,5);

        /**
         * 修改要使用迭代器
         */
//        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
//        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
//        while (iterator.hasNext()){
//            Map.Entry<Integer, Integer> next = iterator.next();
//            iterator.remove();
//            System.out.println(next.getKey()+","+next.getValue());
//        }

        /**
         * foreach 修改会报 java.util.ConcurrentModificationException 并发异常
         */
        map.forEach((k,v)->{
            map.remove(k);
            System.out.println(k+","+v);
        });

    }

}
