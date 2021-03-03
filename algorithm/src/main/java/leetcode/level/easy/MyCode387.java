package leetcode.level.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 */
public class MyCode387 {
    public static void main(String[] args) {

    }

    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length();i++){
            int num = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), ++num);
        }
        for(int i = 0;i < s.length(); i++){
            Character c = s.charAt(i);
            int num = map.get(c);
            if(num == 1){
                return i;
            }
        }
        return -1;
    }

}
