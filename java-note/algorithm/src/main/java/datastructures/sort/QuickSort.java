package datastructures.sort;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] elements = { -2, -1, 3, 0, -9, 7, -6, 12 };
		quickSort(elements, 0, elements.length - 1);
		System.out.println(Arrays.toString(elements));
	}

	public static void quickSort(int[] arr, int left, int right) {
		int l = left; // 左下标
		int r = right;// 右下标
		// pivot 中位值
		int pivot = arr[(left + right) / 2];
		while (l < r) {
			while (arr[l] < pivot) {
				l += 1;
			}

			while (arr[r] > pivot) {
				r -= 1;
			}
			if (l >= r) {
				break;
			}

			// 交换
			int temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;

			if (arr[l] == pivot) {
				r -= 1;
			}
			if (arr[r] == pivot) {
				l += 1;
			}
		}

		if (l == r) {
			l += 1;
			r -= 1;
		}

		// 向左递归
		if (left < r) {
			quickSort(arr, left, r);
		}

		if(right > l) {
			quickSort(arr, l, right);
		}

	}
}
