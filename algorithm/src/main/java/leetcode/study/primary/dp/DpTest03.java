package leetcode.study.primary.dp;

public class DpTest03 {
    public static void main(String[] args) {
        int[] nums = {-2,1};
        int result = maxSubArray(nums);
        System.out.println(result);
    }

    public static int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int maxSubArray = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++){
            //sum要想有资格继续壮大 就必须大于 0 否则还不如恢复0
            sum = Math.max(sum,0);
            sum += nums[i];
            //maxSubArray始终取最大值
            maxSubArray = Math.max(sum,maxSubArray);
        }
        return maxSubArray;
    }

}
