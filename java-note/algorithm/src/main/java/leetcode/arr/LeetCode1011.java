package leetcode.arr;


public class LeetCode1011 {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = shipWithinDays(weights, 5);
        System.out.println(result);
    }

    public static int shipWithinDays(int[] weights, int D) {
        int max = 0;
        int min = 0;
        for (int weight : weights) {
            max += weight;
            min = Math.max(weight, min);
        }
        while (min < max) {
            int mid = (max + min) / 2;
            if (isTransfer(weights, mid, D)) {
                max = mid; //符合可以把右边全砍了
            } else {
                min = mid + 1; //不符合最小值向前进一位
            }
        }
        return min;
    }

    private static boolean isTransfer(int[] weights, int tryWeight, int D) {
        int counter = 0;
        for (int weight : weights) {
            counter += weight;
            if (counter > tryWeight) {
                D--;
                counter = weight;
            }
        }
        return D > 0;
    }

}
