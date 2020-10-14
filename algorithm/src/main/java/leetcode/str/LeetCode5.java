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
        String testStr = "aaaa";
        String result = longestPalindrome2(testStr);
        System.out.println(result);
    }

    /**
     * 暴力破解
     */
    private static String longestPalindrome(String s) {
        int n = s.length();
        int left = 0, right = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j - i > ans && verifyIsPalindrome(s, i, j)) {
                    left = i;
                    right = j;
                    ans = j - i;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    private static boolean verifyIsPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 动态规划
     * 1 2 3 1
     * 4 5 6 1
     * 7 8 9 1
     * 1 1 1 1
     */
    private static String longestPalindrome2(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        boolean[][] dp = new boolean[n][n];
        int begin = 0, maxLength = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[j][i] = false;
                } else {
                    //上述if已经过了 所以头尾一定相等
                    if (i - j < 3) {
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1];
                    }

                    if (dp[j][i] && i - j > maxLength) {
                        begin = j;
                        maxLength = i - j;
                    }

                }
            }
        }
        return s.substring(begin, begin + maxLength + 1);
    }


}
