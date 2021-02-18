package leetcode.study.primary.str;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串""。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。

 */
public class StrTest09 {
    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        String result = longestCommonPrefix(strs);
        System.out.println(result);
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        int min = strs[0].length();
        for(int i = 1; i < strs.length; i++){
            char[] arr1 = strs[i].toCharArray();
            char[] arr2 = strs[i - 1].toCharArray();
            int temp = 0;
            for(int j = 0; j < Math.min(arr1.length,arr2.length);j++){
                boolean flag  = arr1[j] == arr2[j];
                if(!flag) break;
                temp++;
            }
            min = Math.min(min,temp);
        }
        return strs[0].substring(0, min);
    }

}
