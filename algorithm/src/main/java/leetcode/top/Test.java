package leetcode.top;


import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @description: 测试模版
 * @author: dingwei17@jd.com
 * @date : 2024/3/21 15:32
 */
public class Test {

    public static Long sum(Integer[] array) {
        int len = array.length;
        Arrays.sort(array, Collections.reverseOrder());
        for (int i = 1; i < len; ++i)
            if (array[i].equals(array[i - 1])) --array[i];
        Long sum = 0L;
        for (int i = 0; i < len; ++i) {
            sum += Long.valueOf(array[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        Integer[] array = new Integer[k];
        for(int i = 0; i < k; ++i) {
            array[i] = in.nextInt();
        }
        System.out.println(sum(array));

    }

}




