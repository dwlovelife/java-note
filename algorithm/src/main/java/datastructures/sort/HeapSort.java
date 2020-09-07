package datastructures.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 基本思路
 * a.将无序序列构建成一个堆,根据升序降序需求选择大顶堆或小顶堆
 * b.将堆顶元素与末尾元素交换,将最大元素'沉'到数组末端
 * c.重新调整结构,使其满足堆定义,然后继续交换堆顶元素和当前末尾元素,反复执行调整+交换步骤
 * 直到整个序列有序
 */
public class HeapSort {
    public static void main(String[] args) {
        /**
         *             2
         *       1         3
         *    5     4   6     7
         * 9    8
         */
        int[] arr = {2, 1, 3, 5, 4, 6, 7, 9, 8};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        //构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeapNode(arr, i, arr.length);
        }
       /* //调整堆结构+交换堆顶元素和数组末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);
            adjustHeapNode(arr, 0, j);
        }*/
    }

    public static void adjustHeapNode(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k + 1] > arr[k]) {
                k++;
            }
            //如果发生交换了 则看当前发生交换的节点 是否有子节点 如果有则看当前交换节点的左右子节点 是否比temp小 如果有再比较
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
