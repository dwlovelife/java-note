package datastructures.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 选择排序在效率方面要优于冒泡排序 因为只有找到小的那个元素才会替换位置 不像冒泡每一轮都要替换n-1次 才能
 * 最终选择出最小或者最大的那个元素
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] elements = {-2,-1,3,9,-9,7,-6};
		selectSort(elements);
		System.out.println(Arrays.toString(elements));
	}
	
	
	public static void selectSort(int[] elements){
		//只需要比较n-1次 最后剩下一轮的那个数 也就自己确定了 大小位置
		for(int i = 0; i < elements.length - 1; i++){
			int minIndex = i;
			//这一步是要找到最小的值,所以从i开始要遍历到结尾,因为最小的值也可能在尾部
			for(int j = i; j < elements.length; j++){
				if(elements[j] < elements[minIndex]){
					minIndex = j;
				}
			}
			if(minIndex != i){
				int temp = elements[minIndex];
				elements[minIndex] = elements[i];
				elements[i] = temp;;
			}
		}
	}
	
	
}
