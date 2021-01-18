package leetcode.study.primary.str;


public class StrTest05 {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean flag = isPalindrome(s);
        System.out.println(flag);
    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while(i <= j) {
            char start = s.charAt(i);
            char end = s.charAt(j);
            if(!Character.isLetterOrDigit(start)){
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(end)) {
                j--;
                continue;
            }
            if(Character.toLowerCase(start) == Character.toLowerCase(end)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        int n = s.length();
        if (n == 0) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                stringBuilder.append(Character.toLowerCase(c));
            }
        }
        return stringBuilder.toString().equals(stringBuilder.reverse().toString());
    }

}
