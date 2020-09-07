package leetcode.stack;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 输入: "()"
 * 输出: tru
 * 输入: "()[]{}"
 * 输出: true
 * 输入: "(]"
 * 输出: false
 * 输入: "([)]"
 * 输出: false
 * 输入: "{[]}"
 * 输出: true
 */
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
