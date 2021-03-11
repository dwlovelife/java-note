package leetcode.level.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 */
public class MyCode3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring2(s);
        System.out.println(result);
    }

    public static int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer index = map.get(s.charAt(i));
            if (index != null) {
                //abba  遍历第四个a的时候 此时left已经是3了 不应该比3小
                left = Math.max(left, index + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int rk = 0;
        int maxSubArray = 0;
        for(int i = 0; i < s.length(); i++){
            if(i > 0){
                set.remove(s.charAt( i - 1));
            }
            while(rk < s.length() && !set.contains(s.charAt(rk))){
                set.add(s.charAt(rk));
                rk++;
                maxSubArray = Math.max(maxSubArray, rk - i);
            }
        }
        return maxSubArray;
    }


}
