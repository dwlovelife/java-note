package leetcode.level.diffcult;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyCode04 {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2,4};
        double result = findMedianSortedArrays(nums1,nums2);
        System.out.println(result);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            list.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            list.add(nums2[i]);
        }
        Collections.sort(list);
        int medium = list.size() / 2;
        if (list.size() % 2 == 0) {
            return (list.get(medium) + list.get(medium - 1)) / 2d;
        } else {
            return list.get(medium);
        }
    }

}
