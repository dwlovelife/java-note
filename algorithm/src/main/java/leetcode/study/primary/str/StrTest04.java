package leetcode.study.primary.str;


import java.util.Arrays;

public class StrTest04 {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] c1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(t1);
        return Arrays.equals(c1, t1);
    }

}
