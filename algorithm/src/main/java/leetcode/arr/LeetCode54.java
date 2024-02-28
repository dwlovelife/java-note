package leetcode.arr;

import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {
    public static void main(String[] args) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return new ArrayList<>();
            }
            int l = 0, r = matrix.length - 1, t = 0, b = matrix[0].length - 1;
            List<Integer> list = new ArrayList<>(r * b);
            while (true) {
                for (int i = l; i <= r; i++) {
                    list.add(matrix[t][i]);
                }
                if (t++ > b) break;
                for (int i = t; i <= b; i++) {
                    list.add(matrix[i][r]);
                }
                if (l > r--) break;
                for (int i = r; i >= l; i--) {
                    list.add(matrix[b][i]);
                }
                if (t > b--) break;
                for (int i = b; i >= t; i++) {
                    list.add(matrix[i][l]);
                }
                if (l++ > r) break;
            }
            return list;
    }
}
