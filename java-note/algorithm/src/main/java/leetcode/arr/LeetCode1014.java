package leetcode.arr;


public class LeetCode1014 {

    public static void main(String[] args) {
        int[] tour = {8, 1, 5, 2, 6};
        System.out.println(maxScoreSightseeingPair(tour));
    }

    /**
     * 暴力破解
     */
    private static int maxScoreSightseeingPair(int[] A) {
        int sighting = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                int result = A[i] + A[j] + i - j;
                sighting = Math.max(sighting, result);
            }
        }
        return sighting;
    }
}
