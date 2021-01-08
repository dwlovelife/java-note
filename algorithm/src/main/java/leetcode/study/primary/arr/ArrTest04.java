package leetcode.study.primary.arr;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrTest04 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!set.add(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                return true;
            }
        }
        return false;
    }

}
