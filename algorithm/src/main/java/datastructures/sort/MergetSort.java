package datastructures.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergetSort {
	public static void main(String[] args) {
		int[] arr = { 8, 4, 5, 7, 1, 3, 6, 2 };
		int[] temp = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1, temp);
		System.out.println(Arrays.toString(arr));
	}

	public static void mergeSort(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			// 向左递归分解
			mergeSort(arr, left, mid, temp);
			mergeSort(arr, mid + 1, right, temp);
			merge(arr, left, mid, right, temp);
		}
	}

	/**
	 * 归并排序
	 * 
	 * @param arr
	 *            排序的原始数组
	 * @param left
	 *            左边有序序列的初始索引
	 * @param mid
	 *            中间索引
	 * @param right
	 *            右边索引
	 * @param temp
	 *            中转数组
	 */
	public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int i = left; // 初始化i，左边有序序列的初始索引
		int j = mid + 1; // 初始化j,右边有序序列的初始索引
		int t = 0; // 指向temp数组的当前索引

		// 先把左右两边(有序)的数据按照规则填充到temp数组
		// 直到左右两边的有序序列,有一边处理完毕为止
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[t++] = arr[i++];
			} else {
				temp[t++] = arr[j++];
			}
		}

		/**
		 * 把剩余有数组 填充到temp中,如果左边有有序数组 将左边剩余数组填充到temp中 反之亦然
		 */
		while (i <= mid) {
			temp[t++] = arr[i++];
		}
		while (j <= right) {
			temp[t++] = arr[j++];
		}

		// 将temp中的元素拷贝到arr
		t = 0;
		int tempLeft = left;
		while (tempLeft <= right) {
			arr[tempLeft++] = temp[t++];
		}
	}

}
