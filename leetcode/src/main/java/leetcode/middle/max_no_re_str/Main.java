package leetcode.middle.max_no_re_str;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        String sam_str_1="aaaaaaaaa";
        String sam_str_2="au";
        String sam_str_3="pwwkew";

        int result_1 = new Main().lengthOfLongestSubstring(sam_str_1);
        int result_2 = new Main().lengthOfLongestSubstring(sam_str_2);
        int result_3 = new Main().lengthOfLongestSubstring(sam_str_3);

        System.out.println(result_1);
        System.out.println(result_2);
        System.out.println(result_3);

    }

    public int lengthOfLongestSubstring(String s) {
        if (s==null)
            return 0;

        int length = s.length();

        if (length==0)
            return 0;
        if(length ==1)
            return 1;

        int result=0;

        int start=0;
        int end=1;

        HashMap<Character, Integer> temp = new HashMap<>();
        temp.put(s.charAt(start),0);
        while (end<length){
            char ce= s.charAt(end);
            Integer index = temp.get(ce);
            if (index !=null){
                start=index+1;
                temp.clear();
                for (int j=start;j<=end;j++){
                    temp.put(s.charAt(j),j);
                }
            }else {
                temp.put(ce,end);
            }
            end++;
            if (temp.size()>result){
                result=temp.size();
            }
        }
        return result;
    }
}
