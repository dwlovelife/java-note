package leetcode.study.primary.arr;


import java.util.Arrays;

public class ArrTest07 {
    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        int[] result = plusOne(digits);
        System.out.println(Arrays.toString(result));
    }

    public static int[] plusOne1(int[] digits) {
        int n = digits.length;
        int[] sumArr = new int[n];
        int remain = 1;
        for (int i = n - 1; i >= 0; i--) {
            int sum = digits[i] + remain;
            sumArr[i] = (sum) % 10;
            remain = sum / 10;
        }
        if (remain == 0) {
            return sumArr;
        }
        int[] special = new int[n + 1];
        special[0] = remain;
        System.arraycopy(sumArr, 0, special, 1, n);
        return special;
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
