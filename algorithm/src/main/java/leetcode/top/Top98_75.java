package leetcode.top;

public class Top98_75 {
    public static void main(String[] args) {

    }


    public void sortColors(int[] nums) {
        int indexFlag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[indexFlag];
                nums[indexFlag] = temp;
                indexFlag++;
            }
        }
        int newIndexFlag = indexFlag;
        for (int i = indexFlag; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[newIndexFlag];
                nums[newIndexFlag] = temp;
                newIndexFlag++;
            }
        }
    }

}
