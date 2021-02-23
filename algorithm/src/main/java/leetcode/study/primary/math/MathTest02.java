package leetcode.study.primary.math;


import java.util.Arrays;

public class MathTest02 {
    public static void main(String[] args) {
        int n = 499979;
        System.out.println(countPrimes(n));
    }

    public static int countPrimes(int n) {
        boolean[] flags = new boolean[n];
        Arrays.fill(flags, true);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (flags[i]) {
                count++;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        flags[j] = false;
                    }
                }
            }
        }
        return count;
    }

}
