package leetcode.study.primary.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class OtherTest05 {
    public static void main(String[] args) {
        String s = "()";
        boolean result = isValid(s);
        System.out.println(result);
    }


    public static boolean isValid(String s) {
        if(s == null || s.length() % 2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(Character c: s.toCharArray()){
            if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == '('){
                stack.push(')');
            }else{
                if(stack.isEmpty() || stack.pop() != c){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
