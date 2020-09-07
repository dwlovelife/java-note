package datastructures.sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
	public static void main(String[] args) {
		int[] arr = { 53, 3, 542, 748, 14, 214 };
		radixSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	// 基数排序方法
	public static void radixSort(int[] arr) {
		// 先获取数组中最大数的长度
		int max = arr[0];
		for (int ele : arr) {
			max = Math.max(ele, max);
		}
		int maxLength = String.valueOf(max).length();

		/**
		 * 定义桶 1.二维数组包含10个1维数组 2.为了防止在放入数的时候,数据溢出,则每一个一维数组(桶),大小定为arr.length
		 * 明确一下,基数排序是时间换空间的经典算法
		 */
		int[][] bucket = new int[10][arr.length];

		/**
		 * 为了记录每个桶中,实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入数据个数 可以这样理解 比如:
		 * bucketElementCounts[0],记录的就是 bucket[0] 桶的放入数据个数
		 */
		int[] bucketElementsCounts = new int[10];

		for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
			// 第n轮 针对第n个位数进行排序 放入桶中
			for (int j = 0; j < arr.length; j++) {
				// 取出每个元素的个位的值
				int digitOfElement = arr[j] / n % 10;
				// 放入到对应的桶中
				bucket[digitOfElement][bucketElementsCounts[digitOfElement]++] = arr[j];
			}
			// 按照这个桶的顺序(一维数组的下标依次取出数据,放入原数组中)
			int index = 0;
			for (int k = 0; k < bucketElementsCounts.length; k++) {
				if (bucketElementsCounts[k] != 0) {
					// 循环有数据的桶 取出元素放入arr
					for (int l = 0; l < bucketElementsCounts[k]; l++) {
						arr[index++] = bucket[k][l];
					}
				}
				//每次取完数将该桶的数据置为空 复用
				bucketElementsCounts[k] = 0;
			}
		}

	}
}
