package datastructures.search;

import java.util.Arrays;

public class Kmp2 {
    public static void main(String[] args) {
        String dest = "abababzabababa";
        int[] result = kmpNext(dest);
        System.out.println(Arrays.toString(result));
    }

    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            //遍历末尾的主串字符和当前串不相等，那么寻求最大前后缀的方式只能为去next表中去查
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                /*
                 *  查得前一个字符最大前后缀的长度 注意这是长度 比如最大前后缀串为4 那么循环的下标正好取到了第5位
                 *  如果第5位和最后一个字符相等 那么不就说明 最大前后缀是5么 以此类推 反复循环
                 */
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            /**
             *  假设主串与模式串已经存在部分匹配 那么i位置 发现两者不匹配 此时模式串需要查表回退
             *  查看模式串不匹配的前一个位置 j - 1的 最大前缀（表里的数字代表 当前位置的最大公共前缀长度）
             *  比如是4 abcd是最大前缀串(abcde...) 如果刚刚好 str2.charAt(j) = e  如果 刚好等于 str1.charAt(i)
             *  能挂上 说明刚刚好 j并没有回退到初始位置 前缀串正好匹配
             */
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

}
