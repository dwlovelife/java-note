package leetcode.study.primary;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class TempTest02 {
    public static void main(String[] args) {
        String s = "a";
        String t = "b";
        boolean result = isAnagram(s, t);
        System.out.println(result);
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] c1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(t1);
        return Arrays.equals(c1, t1);
    }

}
