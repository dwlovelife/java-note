package datastructures.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 核心过程就是每轮两两往后交换 直到最大或最小的数 到尾部
 * 此过程进行N-1轮
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] elements = {-2,-1,3,9,-9,7,-6};
		bubbleSort(elements);
		System.out.println(Arrays.toString(elements));
	}

	public static void bubbleSort(int[] elements) {
		// 总共要排序n - 1次
		//如果在冒泡排序在某一次交换过程中,没有进行任何交换,说明已经是有序的了
		boolean flag;
		for (int i = 0; i < elements.length; i++) {
			flag = false;
			for (int j = 0; j < elements.length - 1 - i; j++) {
				if (elements[j] > elements[j + 1]) {
					int temp = elements[j];
					elements[j] = elements[j + 1];
					elements[j + 1] = temp;
					flag = true;
				}
			}
			if (!flag) {
				break;
			}
		}

	}

}
