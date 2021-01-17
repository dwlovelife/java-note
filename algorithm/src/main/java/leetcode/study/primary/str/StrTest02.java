package leetcode.study.primary.str;

public class StrTest02 {
    public static void main(String[] args) {

    }

    public int reverse(int x) {
        int remain = 0;
        int result = 0;
        while(x != 0){
            remain = x % 10;
            x /= 10;
            //判断下一次会不会溢出
            boolean flag1 = result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && remain > 7;
            boolean flag2 = result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && remain < -8;
            if(flag1 || flag2){
                return 0;
            }
            result = result * 10 + remain;
        }
        return result;
    }

}
