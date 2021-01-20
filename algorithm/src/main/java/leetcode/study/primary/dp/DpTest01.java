package leetcode.study.primary.dp;


public class DpTest01 {
    public static void main(String[] args) {
        int result = climbStairs(3);
        System.out.println(result);
    }

    public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        return calculateStep(arr, n);
    }

    private static int calculateStep(int[] arr, int n) {
        int result = arr[n];
        if (result != 0) {
            return result;
        }
        result = calculateStep(arr, n - 1) + calculateStep(arr, n - 2);
        arr[n] = result;
        return result;
    }

}
