package leetcode.study.primary;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 */
public class TempTest01 {
    public static void main(String[] args) {

    }

    public int firstUniqChar(String s) {
        int n = s.length();
        Map<Character, Integer> container = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int count = container.getOrDefault(s.charAt(i), 0) ;
            container.put(s.charAt(i), count + 1);
        }
        for (int i = 0; i < n; i++) {
            int count = container.get(s.charAt(i));
            if(count == 1){
                return i;
            }
        }
        return -1;
    }

}
