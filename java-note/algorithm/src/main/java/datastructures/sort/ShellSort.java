package datastructures.sort;

import java.util.Arrays;

/**
 * 希尔排序时希尔于1959年提出的一种排序算法,希尔排序也是一种插入排序,
 * 它是简单插入排序经过改进之后的一个更高效的版本,也称为缩小增量排序
 * <p>
 * 基本思想:
 * 希尔排序是把记录按下标的一定增量分组,对每组使用直接插入排序算法排序,
 * 随着增量逐渐减少,每组包含的关键词越来越多,当增量减至1时,整个文件
 * 恰被分成一组,算法便终止.
 *
 * 移位法由于 插入法 没有那么多的交换操作 所以移位法的希尔排序 速度远快于交换法
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] elements1 = {80, 30, 60, 40, 20, 10, 50, 70};
        int[] elements2 = {80, 30, 60, 40, 20, 10, 50, 70};
        shellSortByExchange(elements1);
        shellSortByMove(elements2);
        System.out.println(Arrays.toString(elements1));
        System.out.println(Arrays.toString(elements2));
    }

    /**
     * 希尔排序-交换法
     */
    private static void shellSortByExchange(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    /**
     * 希尔排序移位法
     */
    private static void shellSortByMove(int[] arr) {
        for (int gap = arr.length; gap > 0; gap /= 2){
            for(int i = gap; i < arr.length;i++){
                int j = i;
                int temp = arr[j];
                while(j - gap >= 0 && temp < arr[j - gap]){
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

}
