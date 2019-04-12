package leetcode.middle.longest_palindrome;

/**
 * 最大回文子串
 */
public class Main {

    public static void main(String[] args) {

        // bab 或 aba
        String str1 = "babad";

        // bb
        String str2 = "abbc";

        String str3 = "ccc";

        String str4 = "aaaa";

        System.out.println(1);
        String result1 = new Main().longestPalindrome(str1);
        System.out.println(result1);
        System.out.println(2);
        String result2 = new Main().longestPalindrome(str2);
        System.out.println(result2);
        System.out.println(3);
        String result3 = new Main().longestPalindrome(str3);
        System.out.println(result3);
        System.out.println(4);
        String result4 = new Main().longestPalindrome(str4);
        System.out.println(result4);

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

    public String longestPalindromeOther(String s) {
        int len = s.length();
        while (len > 0) {
            for (int i = 0; i < s.length() - len + 1; i++) {
                if (isPalindrome(s, i, i + len - 1))
                    return s.substring(i, len + i);
            }
            len--;
        }
        return "";
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
