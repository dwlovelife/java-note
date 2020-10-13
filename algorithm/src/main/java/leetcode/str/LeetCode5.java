package leetcode.str;

/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LeetCode5 {
    public static void main(String[] args) {
        String testStr = "ac";
        String result = longestPalindrome(testStr);
        System.out.println(result);
    }

    private static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int ans = 1;
        int left = 0;
        int right = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if(j - i >= ans && verifyIsPalindrome(chars,i,j)){
                    ans = j - i;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left,right + 1);
    }

    private static boolean verifyIsPalindrome(char[] chars,int i,int j){
        int left = i;
        int right = j;
        while(left < right){
            if(chars[left] != chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}
