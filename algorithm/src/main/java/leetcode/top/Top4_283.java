package leetcode.top;

/**
 * @description: 移动零
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * @author: dingwei17@jd.com
 * @date : 2024/3/5 22:02
 */
public class Top4_283 {


    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int slow = 0, fast = slow + 1;
        while (fast < nums.length) {
            if (nums[slow] == 0) {
                if (nums[fast] != 0) {
                    int temp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = temp;
                    slow++;
                }
            } else {
                slow++;
            }
            fast++;
        }
    }

}
