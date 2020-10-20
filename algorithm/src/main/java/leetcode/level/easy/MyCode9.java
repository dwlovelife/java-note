package leetcode.level.easy;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 输入: 121
 * 输出: true
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 */
public class MyCode9 {
    public static void main(String[] args) {
        int nums = -121;
        boolean result = isPalindrome(nums);
        System.out.println(result);
    }

    /**
     * 01. 弄成字符串再使用二分法(应该直接用数字转 有点投机取巧)
     */
    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
