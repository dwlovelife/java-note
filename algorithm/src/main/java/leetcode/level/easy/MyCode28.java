package leetcode.level.easy;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class MyCode28 {
    public static void main(String[] args) {
        String hayStack = "aac";
        String needle = "ac";
        int index = strStr2(hayStack, needle);
        System.out.println(index);
    }

    public static int strStr1(String haystack, String needle) {
        if (needle == null) return -1;
        if (needle.isEmpty()) return 0;
        int index = -1;

        int n = needle.length();

        l:
        for (int i = 0; i + n - 1 < haystack.length(); i++) {
            int x = i;
            int y = 0;
            while (haystack.charAt(x) == needle.charAt(y)) {
                if (y == n - 1) {
                    index = i;
                    break l;
                }
                x++;
                y++;
            }
        }
        return index;
    }

    public static int strStr2(String haystack, String needle) {
        if (needle == null) return -1;
        else if (needle.length() == 0) return 0;

        int n = needle.length();
        for (int i = 0; i < haystack.length() - n + 1; i++) {
            if(haystack.substring(i,n + i).equals(needle)){
                return i;
            }
        }
        return -1;
    }

}
