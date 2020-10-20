package leetcode.level.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * L             50
 * C             100
 * D             500
 * M             1000
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 */
public class MyCode13 {

    public static void main(String[] args) {
        String s = "III";
        int result = romanToInt2(s);
        System.out.println(result);
    }

    /**
     * 解法一： 自己的解法
     */
    static Map<Character, Integer> map;

    static {
        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public static int romanToInt1(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer currentNum = map.get(s.charAt(i));
            if (i + 1 < s.length() && map.get(s.charAt(i + 1)) > currentNum) {
                currentNum = map.get(s.charAt(++i)) - currentNum;
            }
            result += currentNum;
        }
        return result;
    }

    /**
     * 解法二：
     */
    public static int romanToInt2(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int curNum = getValue(s.charAt(i));
            if (preNum < curNum) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = curNum;
        }
        sum += preNum;
        return sum;
    }

    public static int getValue(char element) {
        switch (element) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        throw new RuntimeException("找不到对应的值");
    }

}
