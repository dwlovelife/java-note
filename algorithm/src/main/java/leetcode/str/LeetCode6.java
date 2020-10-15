package leetcode.str;


import java.util.ArrayList;
import java.util.List;

public class LeetCode6 {
    public static void main(String[] args) {
        String str = "LEETCODEISHIRING";
        String result = convert(str, 3);
        System.out.println(result);
    }

    /**
     * LEETCODEISHIRING
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     */
    public static String convert(String s, int numRows) {
        int n = s.length();
        if (numRows > n || numRows < 2) {
            return s;
        }
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            stringBuilders[i] = new StringBuilder();
        }
        boolean goingDown = false;
        int curRow = 0;
        for (int i = 0; i < n; i++) {
            stringBuilders[curRow].append(s.charAt(i));
            if (curRow == 0 || curRow + 1 == numRows) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder builder = new StringBuilder();
        for(StringBuilder stringBuilder:stringBuilders){
            builder.append(stringBuilder.toString());
        }
        return builder.toString();
    }

}
