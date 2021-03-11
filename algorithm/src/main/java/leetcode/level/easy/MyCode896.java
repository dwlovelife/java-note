package leetcode.level.easy;

public class MyCode896 {
    public static void main(String[] args) {
        int[] arr = {3,1,9};
        System.out.println(isMonotonic(arr));
    }

    public static boolean isMonotonic(int[] A) {
        if(A == null || A.length <= 2){
            return true;
        }
        int flag = Integer.compare(A[A.length - 1] - A[0], 0);
        if(flag == 0){
            for (int i = 1; i < A.length; i++){
                int result = A[i] - A[i - 1];
                if((result !=  0)){
                    return false;
                }
            }
        }else if(flag == 1){
            for (int i = 2; i < A.length; i++){
                int result = A[i] - A[i - 1];
                if((result <  0)){
                    return false;
                }
            }
        }else {
            for (int i = 2; i < A.length; i++){
                int result = A[i] - A[i - 1];
                if((result >  0)){
                    return false;
                }
            }
        }
        return true;
    }



}
