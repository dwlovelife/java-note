package leetcode.level.medium;

import java.util.HashMap;
import java.util.Map;

public class MyCode395 {
    public static void main(String[] args) {
        String s = "ababbc";
        int k = 2;
        int result = longestSubstring(s, k);
        System.out.println(result);
    }

    public static int longestSubstring(String s, int k) {
        Map<Character,Integer>  map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            int count = map.getOrDefault(s.charAt(i),0);
            map.put(s.charAt(i), ++count);
        }
        int sum = 0;
        for(Integer count:map.values()){
            if(count >= k) {
                sum += count;
            }
        }
        return sum;
    }

}
