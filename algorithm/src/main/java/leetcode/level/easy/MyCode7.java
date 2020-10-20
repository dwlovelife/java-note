package leetcode.level.easy;

import java.util.function.Predicate;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class MyCode7 {

    public static void main(String[] args) {
        int num = 12;
        int result = reverse(num);
        System.out.println(result);
    }

    public static int reverse(int x){
        int rev = 0;
        while(x != 0){
            int pop = x % 10;
            x /= 10;
            boolean flag1 = rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && pop > 7;
            boolean flag2 = rev < Integer.MIN_VALUE / 10 || rev == Integer.MIN_VALUE / 10 && pop < -8;
            if(flag1 || flag2){
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

}
