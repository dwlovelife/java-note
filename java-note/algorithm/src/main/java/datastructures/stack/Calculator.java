package datastructures.stack;

import java.util.Stack;

/**
 * 使用栈完成表达式的计算思路
 * 1. 通过index值（索引）,来遍历我们的表达式
 * 2. 如果我们发现是一个数字,就直接入数栈
 * 3. 如果我们发现是一个符号,就分如下情况
 * 3.1 如果我们发现当前的符号栈为空,就进行比较,如果发现当前的操作符的优先级小于等于栈中的操作符
 * 就要从数栈中pop出两个数,再从符号栈中pop一个符号,进行运算,将得到结果,入数栈,然后将当前的操作符
 * 入符号栈,如果当前操作符的优先级大于栈中的操作符,就直接入符号栈
 * 4. 当表达式扫描完毕,就顺序的从数栈和符号栈中pop出相应的数和符号,并运行
 * 5. 最后在数栈只有一个数字就是表达式的结果
 */
public class Calculator {
    public static void main(String[] args) {
        //根据思路,完成表达式的运算
        String expression = "3+2*6-2";
        //创建两个栈一个数字栈,一个符号栈
        Stack<Integer> numStack = new Stack<>();
        Stack<Integer> operatorStack = new Stack<>();
        //定义需要的相关变量
        char[] chars = expression.toCharArray();
        int num1 = 0;
        int num2 = 0;
        int operator = 0;
        int res = 0;
        for (char ele : chars) {
            //判断元素是什么,然后进行相应的处理
            if (isOperator(ele)) {
                //判断当前符号栈是否为空
                if (!operatorStack.isEmpty()) {
                    //如果符号栈有操作符,就进行比较,如果当前的操作符的优先级小于等于栈中的操作符,就需要从数栈中pop出两个数
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    operator = operatorStack.pop();
                    res = cal(num1, num2, operator);
                    //把运算的结果push数字栈
                    numStack.push(res);
                    //然后将
                } else {

                }
            } else {

            }
        }
    }

    //返回运算符的优先级,优先级是由程序员决定的,优先级使用数字表示
    //数字越大,则优先级越高
    public static int priority(int operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1; //假定目前只有加乘除
        }
    }

    //判断是不是一个运算符
    public static boolean isOperator(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public static int cal(int num1, int num2, int operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                break;
        }
        return result;
    }

}

