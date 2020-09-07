package datastructures.sort;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] elements = { 6, 1, 2, 7, 9, 10, 4, 5, 10, 8 };
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
			while (l < r && arr[r] >= base) {
				r--;
			}
			while (l < r && arr[l] <= base) {
				l++;
			}
			if (r > l) {
				swap(arr, l, r);
			}
		}
		// 当左右两边指针重合时,将基准数与指针指向数字交换
		swap(arr, l, left);
		// 将指针左边递归
		quickSort(arr, left, l - 1);
		// 右边同理
		quickSort(arr, r + 1, right);
	}

	// swap方法
	public static void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

}
