package leetcode.study.primary.str;

public class StrTest01 {
    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        int n = s.length;
        if(n == 0 || n == 1){
            return;
        }

        for(int i = 0; i < n / 2; i++){
            char temp = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i]= temp;
        }
    }

}
