package leetcode.sword;

/**
 左旋转字符串
 */
public class Test07 {

    public String reverseLeftWords(String s, int n) {
        char[] arrays = s.toCharArray();
        char[] result = new char[arrays.length];
        for(int i = 0; i < arrays.length; i++) {
            if(i < n) {
                result[arrays.length - n + i] = arrays[i];
            } else {
                result[i - n] = arrays[i];
            }
        }
        return new String(result);
    }

}
