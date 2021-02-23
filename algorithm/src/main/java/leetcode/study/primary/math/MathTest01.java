package leetcode.study.primary.math;


import java.util.ArrayList;
import java.util.List;

public class MathTest01 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(fizzBuzz(n));
    }

    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            String str = String.valueOf(i);
            boolean flag1 = i % 3 == 0;
            boolean flag2 = i % 5 == 0;
            if (flag1 && flag2) {
                str = "FizzBuzz";
            } else if (flag1) {
                str = "Fizz";
            } else if (flag2) {
                str = "Buzz";
            }
            result.add(i - 1, str);
        }
        return result;
    }

}
