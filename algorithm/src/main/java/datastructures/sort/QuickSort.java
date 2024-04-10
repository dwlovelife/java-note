package datastructures.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] elements = {5,1,2,3,4,6};
        quickSort(elements, 0, elements.length - 1);
        System.out.println(Arrays.toString(elements));
    }

    /**
     * 快速排序 从小到大排
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int base = arr[left];
        int l = left;
        int r = right;
        while (l < r) {

        }
    }

    // swap方法
    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
