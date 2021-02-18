package leetcode.study.primary.sort;

import java.util.Arrays;

public class SortTest01 {

    public static void main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0){
            return;
        }
        int i = 0;
        int j = 0;
        while(j < n ){
            if(nums1[i] > nums2[j]){
                System.arraycopy(nums1, i , nums1, i + 1, nums1.length - 1 - i);
                nums1[i++] = nums2[j++];
            }
        }
    }
}
