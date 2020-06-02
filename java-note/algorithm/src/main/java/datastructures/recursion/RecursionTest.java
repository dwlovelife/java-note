package datastructures.recursion;


public class RecursionTest {

    public static void main(String[] args) {
        //通过打印问题 回顾递归调用机制
        for(int i =0; i <= 10;i++){
            System.out.println(fiboracci(i));
        }

    }

    //打印问题
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);
    }

    //阶乘问题
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

    //n>2 斐波那契数列
    public static int fiboracci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fiboracci(n - 1) + fiboracci(n - 2);
        }
    }


}
