package leetcode.level.easy;


public class MyCode605 {
    public static void main(String[] args) {
        boolean result = canPlaceFlowers(new int[]{0, 0, 1, 0, 1}, 1);
        System.out.println(result);
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int total = 0;
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                count++;
            } else {
                if (count == i && count >= 2) {
                    total += count / 2;
                } else if (count >= 3) {
                    total += (count - 1) / 2;
                }
                count = 0;
            }
        }
        if (count > 0) {
            if (count == flowerbed.length) {
                total = (count + 1) / 2;
            } else {
                total += count / 2;
            }
        }
        return total >= n;
    }

}
