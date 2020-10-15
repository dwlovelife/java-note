package leetcode.math;


public class LeetCode7 {
    public static void main(String[] args) {
        int a = 111;
        System.out.println(reverse(a));
    }


    public static int reverse(int x) {
        try {
          return   x > 0 ? Integer.parseInt(new StringBuilder(x + "").reverse().toString()) :
                    -1*Integer.parseInt(new StringBuilder(x*-1 + "").reverse().toString());
        }catch (Exception e){
            return 0;
        }
    }

}
