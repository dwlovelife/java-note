package priciple.liskov.improve;

/**
 *  里氏替换原则基本介绍
 *  核心点就是： 在使用继承时,遵循里氏替换原则,在子类中尽量不要重写父类的方法
 *  里氏替换原则告诉我们，继承实际上让两个类耦合性增强了,在适当的情况下,可以通过聚合,组合,依赖来解决问题
 */
public class Liskov {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("11-3=" + a.func1(11,3));
        System.out.println("1-8=" + a.func1(1,8));
        System.out.println("-----------------------");
        //因为B类 不再继承A类 因此调用者 不会认为func1是求减法了
        //调用完成的功能就会很明确
        B b = new B();
        System.out.println("11-3=" + b.func1(11,3));
        System.out.println("1-8=" + b.func1(1,8));
        System.out.println("11+3+9=" + b.func2(11,3));

        //且使用组合依然可以使用到A类的相关方法
        System.out.println("11-3=" + b.func3(11,3));
    }
}

//创建一个更加基础的类
class Base {
    //把更加基础的方法和成员写到Base类中
}

//A类
class A extends Base {
    //返回两个数的差
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

//B类继承了A
//增加了一个新功能,完成两个数相加，然后和9求和 -> 这里B 其实继承A 后，硬是修改了继承方法，这显得继承没有意义
class B extends Base {
    //如果B需要使用A类的方法,使用组合关系
    private A a = new A();

    //如果B类需要使用A类的方法，使用组合关系
    //这里重写了A类的方法,可能是无意识
    public int func1(int a,int b){
        return a + b;
    }

    public int func2(int a,int b){
        return func1(a,b) + 9;
    }

    public int func3(int a,int b){
        return this.a.func1(a,b);
    }

}