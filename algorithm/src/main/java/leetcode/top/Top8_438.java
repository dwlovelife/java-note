package leetcode.top;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 */
public class Top8_438 {
    public static void main(String[] args) {

    }

    public List<Integer> findAnagrams(String s, String p) {
        if (p == null || s == null) {
            return new ArrayList<>();
        }
        int[] arr = new int[256];
        for (int i = 0; i < p.length(); i++) {
            arr[p.charAt(i) - 'a']++;
        }
        //起始位置
        int start = 0;
        List<Integer> list = new ArrayList<>();
        for (int l = 0; l < s.length(); l++) {
            arr[s.charAt(l) - 'a']--;
            while (arr[s.charAt(l) - 'a'] < 0) {
                arr[s.charAt(start) - 'a']++;
                start++;
            }
            if (l - start + 1 == p.length()) {
                list.add(start);
            }
        }
        return list;
    }

}
