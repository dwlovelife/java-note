package priciple.ocp.improve;

/**
 * 开闭原则
 * 方式1的改进思路分析
 *
 *思路：把创建的Shape类做成抽象类，并提供一个抽象的draw方法，让子类去实现即可，这样我们有新的图形种类时，
 * 只要让新的图形类继承shape,并实现draw方法即可
 * 满足对扩展开发，对修改关闭的原则
 */
public class Ocp {
    public static void main(String[] args) {
        //使用看看存在的问题
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Triangle());
    }
}

class GraphicEditor {
    public void drawShape(Shape s) {
       s.draw();
    }


}

abstract class Shape {
    int m_type;

    public abstract void draw();
}

class Rectangle extends Shape {
    Rectangle() {
        super.m_type = 1;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制矩形 ");
    }
}

class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制原型 ");
    }
}

//新增三角形 +
class Triangle extends Shape {
    Triangle() {
        super.m_type = 3;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制三角形 ");
    }
}