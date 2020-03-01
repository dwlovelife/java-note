package priciple.ocp;

/**
 * 开闭原则
 * 方式1的优缺点
 * 1.优点是比较好理解,简单易操作
 * 2.缺点是违反了设计模式的ocp原则,即对扩展开放,对修改关闭。当我们给类增加新功能的时候尽量不修改代码
 * 或者尽可能少修改代码
 * 3.比如我们这时要新增加一个图形种类，我们需要做如下修改，修改的地方比较多
 * 4.代码演示
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
        if (s.m_type == 1) {
            drawRectangle(s);
        } else if (s.m_type == 2) {
            drawCircle(s);
            //新增三角形+
        } else if (s.m_type == 3) {
            drawRectangle(s);
        }
    }

    public void drawRectangle(Shape r) {
        System.out.println(" 绘制矩形 ");
    }

    public void drawCircle(Shape r) {
        System.out.println(" 绘制圆形 ");
    }

    //新增代码 +
    public void drawTriangle(Shape r){
        System.out.println(" 绘制三角形 ");
    }

}

class Shape {
    int m_type;
}

class Rectangle extends Shape {
    Rectangle() {
        super.m_type = 1;
    }
}

class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }
}

//新增三角形 +
class Triangle extends Shape {
    Triangle() {
        super.m_type = 3;
    }
}