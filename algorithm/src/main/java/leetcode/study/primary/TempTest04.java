package leetcode.study.primary;



public class TempTest04 {
    public static void main(String[] args) {
        String s = "   -42";
        int result = myAtoi(s);
        System.out.println(result);
    }

    public static int myAtoi(String s) {
        s = s.trim();
        int n = s.length();
        if (n == 0 || (!Character.isDigit(s.charAt(0)) && s.charAt(0) != '-' && s.charAt(0) != '+')) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                break;
            }
            sb.append(c);
        }

        String result = sb.toString();
        if((result.charAt(0) == '-' || result.charAt(0) == '+')&& result.length() == 1){
            return 0;
        }
        try {
            return Integer.parseInt(result);
        }catch (Exception e){
            if(s.charAt(0) == '-'){
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
    }

}
