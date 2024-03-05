package leetcode;



/**
 * @description: TODO
 * @author: dingwei17@jd.com
 * @date : 2023/10/16 15:47
 */
public class Test {
    public static void main(String[] args) {
        reverseStr("abcdefg", 2 );
    }

    public static String reverseStr(String s, int k) {
        if (s == null || s.equals("")) {
            return s;
        }
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i += 2*k) {
            int left = i;
            int right = Math.min(i + k, c.length) - 1;
            while (left < right) {
                char temp = c[left];
                c[left] = c[right];
                c[right] = temp;
                left++;
                right--;
            }
        }
        return new String(c);
    }


}
