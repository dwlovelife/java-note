package leetcode.str;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 无重复字符串的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 */
public class LeetCode3 {
    public static void main(String[] args) {
        String testStr = "abba";
        int maxLength = lengthOfLongestSubstring2(testStr);
        System.out.println(maxLength);
    }

    /**
     * 以 (a)bcabcbb 开始的最长字符串为 (abc)abcbb；
     * 以 a(b)cabcbb 开始的最长字符串为 a(bca)bcbb；
     * 以 ab(c)abcbb 开始的最长字符串为 ab(cab)cbb；
     * 以 abc(a)bcbb 开始的最长字符串为 abc(abc)bb；
     * 以 abca(b)cbb 开始的最长字符串为 abca(bc)bb；
     * 以 abcab(c)bb 开始的最长字符串为 abcab(cb)b；
     * 以 abcabc(b)b 开始的最长字符串为 abcabc(b)b；
     * 以 abcabcb(b) 开始的最长字符串为 abcabcb(b)
     */
    private static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        //i,j均可理解为下标
        int i = 0, j = 0, ans = 0, n = s.length();
        while (i < n && j < n) {
            Character element = s.charAt(j);
            if (map.containsKey(element)) {
                i = Math.max(map.get(element) + 1, i);
            }
            map.put(element, j);
            ans = Math.max(ans, ++j - i);
        }
        return ans;
    }

    private static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int record = 0, ans = 0; //record理解成指针
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (record < n && !set.contains(s.charAt(record))) {
                set.add(s.charAt(record));
                record++;
            }
            ans = Math.max(ans, record - i);
        }
        return ans;
    }
}
