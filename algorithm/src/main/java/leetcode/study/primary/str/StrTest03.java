package leetcode.study.primary.str;

import java.util.HashMap;
import java.util.Map;

public class StrTest03 {
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
