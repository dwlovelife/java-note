package leetcode.sword;

/**
 剑指 Offer 05. 替换空格
 输入：s = "We are happy."
 输出："We%20are%20happy."
 */
public class Test06 {


    public String replaceSpace(String s) {
        char[] arrays = s.toCharArray();
        char[] resultArray = new char[arrays.length * 3];
        int size = 0;
        for (char array : arrays) {
            if (array == ' ') {
                resultArray[size++] = '%';
                resultArray[size++] = '2';
                resultArray[size++] = '0';
            } else {
                resultArray[size++] = array;
            }
        }
        return new String(resultArray, 0 , size);
    }

}
