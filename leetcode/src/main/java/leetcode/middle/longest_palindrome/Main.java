package leetcode.middle.longest_palindrome;

/**
 * 最大回文子串，对问题要分析清楚
 */
public class Main {

    public static void main(String[] args) {

        // bab 或 aba
        String str1 = "babad";

        // bb
        String str2 = "abbc";

        // ccc
        String str3 = "ccc";

        String result1 = new Main().longestPalindrome(str1);
        String result2 = new Main().longestPalindrome(str2);
        String result3 = new Main().longestPalindrome(str3);

        System.out.println();

    }

    public String longestPalindrome(String s) {

        String result = "";
        if (s == null)
            return result;
        int length = s.length();
        if (length == 0)
            return result;
        if (length == 1)
            return s;

        int subLength = 0;
        for (int index = 0; index < length; index++) {
            int lIndex = index;
            int rIndex = index;
            while (rIndex < length) {
                if (s.charAt(index) == s.charAt(rIndex)) {
                    rIndex = rIndex + 1;
                } else {
                    break;
                }
            }
            rIndex--;


            while (true) {
                if (lIndex <= -1 || rIndex >= length) {
                    lIndex += 1;
                    rIndex -= 1;
                    break;
                }
                if (s.charAt(lIndex) == s.charAt(rIndex)) {
                    lIndex -= 1;
                    rIndex += 1;
                } else {
                    lIndex += 1;
                    rIndex -= 1;
                    break;
                }
            }
            if (rIndex - lIndex + 1 > subLength) {
                result = s.substring(lIndex, rIndex + 1);
                subLength = rIndex - lIndex + 1;
            }
        }
        return result;
    }
}
