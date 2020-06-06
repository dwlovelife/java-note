package datastructures.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 中缀表达式->后缀表达式 1).初始化两个栈 2).从左至右扫描中缀表达式 3).遇到操作数时,将其压s2
 * 4).遇到运算符时,比较其与s1栈顶运算符的优先级, 1.如果s1为空,或栈顶运算符为左括号"(",则直接将此运算符入栈
 * 2.否则,若优先级比栈顶的运算符高,也将运算符压入栈s1 3.否则,将s1栈顶的运算符弹出并压入到s2中,再次转到(4,1)与s1中新的栈顶运算符相比较
 * 5).遇到括号时: (1) 如果是左括号"(",则直接压入s1 (2)
 * 如果是右括号")",则依次弹出s1栈顶的运算符,并压入s2,直到遇到左括号为止,此时将这一对括号 丢弃 6) 重复步骤2至5,直到表达式的最右边 7)
 * 将s1中剩余的运算符依次并弹出压入s2 8) 依次弹出s2中的元素并输出,结果的逆序即为中缀表达式对应的后缀表达式
 *
 */
public class InfixExpressionToSuffix {
	public static void main(String[] args) {
		// 完成将一个中缀表达式转后缀表达式的功能
		// 说明
		// 1. 1+((2+3))x4)-5 => 转成 1 2 3 + 4 x + 5 -
		// 2. 因为直接对str 进行操作,不方便,因此 先将 "1+((2+3)x4)-5" => 中缀表达式对应的List
		String expression = "1+((2+3)*4)-5";
		List<String> list = toInfixExpressionList(expression);
		System.out.println(list);
		List<String> suffixExpression = parseSuffixExpressionList(list);
		System.out.println(suffixExpression);
	}

	// 即 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5] => ArrayList [1,2,3,+,4,*,+,5,-]
	// 方法：将得到的后缀表达式对应的list => 后缀表达式对应的list
	public static List<String> parseSuffixExpressionList(List<String> ls) {
		// 定义两个栈
		Stack<String> s1 = new Stack<>();
		// 说明:因为s2这个栈在整个过程中,没有pop操作,而且后面我们还需要逆序操作,所以这里用ArrayList较为方便
		List<String> s2 = new ArrayList<>();

		// 遍历ls
		for (String s : ls) {
			if (s.matches("\\d+")) {
				s2.add(s);
			} else if (s.equals("(")) {
				s1.push(s);
			} else if (s.equals(")")) {
				while (!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop();
			} else {
				while (s1.size() != 0 && priority(s1.peek()) >= priority(s)) {
					s2.add(s1.pop());
				}
				s1.push(s);
			}
		}
		return s2;
	}

	public static int priority(String operator) {
		if ("*".equals(operator) || "\\".equals(operator)) {
			return 1;
		} else if ("+".equals(operator) || "-".equals(operator)) {
			return 0;
		} else {
			return -1; // 假定目前只有加乘除
		}
	}

	// 将一个中缀表达式转换成一个list
	public static List<String> toInfixExpressionList(String expression) {
		// 定义一个List,存放中缀表达式,对应的内容
		List<String> ls = new ArrayList<>();
		char[] chars = expression.toCharArray();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			Character ele = chars[i];
			if (ele < 48 || ele > 57) {
				ls.add(ele.toString());
			} else {
				if (i == chars.length - 1) {
					ls.add(ele.toString());
				} else {
					builder.append(ele);
					if (chars[i + 1] < 48 || chars[i + 1] > 57) {
						ls.add(builder.toString());
						builder.delete(0, builder.length());
					}
				}
			}
		}
		return ls;
	}

	
}
