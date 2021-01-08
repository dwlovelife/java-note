package leetcode.study.primary.arr;



public class ArrTest05 {
    public static void main(String[] args) {

    }

    /**
     * 位运算
     * a^0 = a
     * a^a = 0
     * a^b^a = b
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            single = single ^ nums[i];
        }
        return single;
    }
}
