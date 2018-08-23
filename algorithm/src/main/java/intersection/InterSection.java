package intersection;

import java.util.HashSet;
import java.util.Set;

public class InterSection {

    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(4);
        set2.add(5);

        System.out.println(interSection(set1,set2));
        System.out.println(unionSection(set1,set2));
        System.out.println(differenceSection(set1,set2));

    }

    /* 交集 */
    public static Set<Integer> interSection(Set<Integer> s1,Set<Integer> s2){
        s1.retainAll(s2);
        return s1;
    }

    /* 并集 */
    public static Set<Integer> unionSection(Set<Integer> s1,Set<Integer> s2){
        s1.addAll(s2);
        return s1;
    }


    /* 差集 */
    public static Set<Integer> differenceSection(Set<Integer> s1,Set<Integer> s2){
        s1.removeAll(s2);
        return s1;
    }

}
