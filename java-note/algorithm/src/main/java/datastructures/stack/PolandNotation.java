package datastructures.stack;

import java.util.Stack;

/**
 * 逆波兰表达式
 */
public class PolandNotation {
	public static void main(String[] args) {
		
		//先定义一个逆波兰表达式
		//(3+4)x5-6 => 3 4 + 5 x 6 -
		String suffixExpression = "3 4 + 5 * 6 -";
		String[] element = suffixExpression.split(" ");
		Stack<Integer> stack = new Stack<>();
		for(String ele:element){
			if(ele.matches("\\d+")){
				stack.push(Integer.parseInt(ele));
			}else{
				int num1 = stack.pop();
				int num2 = stack.pop();
				stack.push(cal(num2, num1, ele));
			}
		}
		System.out.printf("结果为:%d",stack.pop());
	}
	
	public static int cal(int num1, int num2, String operator) {
        Integer result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                break;
        }
        return result;
    }
	
}

