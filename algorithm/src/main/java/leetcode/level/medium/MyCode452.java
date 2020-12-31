package leetcode.level.medium;


import java.util.Arrays;

public class MyCode452 {
    public static void main(String[] args) {
        //int[][] arr = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int[][] arr = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int result = findMinArrowShots(arr);
        System.out.println(result);
    }


    public static int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n == 0) {
            return 0;
        }
        Arrays.sort(points, (x, y) -> x[1] - y[1]);
        int ans = 1;
        int element = points[0][1];
        boolean flag = true;
        for (int i = 1; i < n; i++) {
            if(element >= points[i][0] && points[i][1] >= element){
                flag = false;
            }else{
                flag = true;
                element = points[i][1];
            }
            if(flag){
                ans++;
            }
        }
        return ans;
    }

}
