package leetcode.stack;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode20 {

    static Map<Character,Character> match ;
    static {
        match = new HashMap<>();
        match.put(')','(');
        match.put(']','[');
        match.put('}','{');
    }

    public static void main(String[] args) {
        String s = "([)]";
        boolean flag = isValid(s);
        System.out.println(flag);
    }


    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        if(chars.length % 2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(char c:chars){
            Character ele = match.get(c);
            if(ele == null){
                stack.push(c);
            }else{
                if(stack.isEmpty() || !stack.pop().equals(ele)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}
