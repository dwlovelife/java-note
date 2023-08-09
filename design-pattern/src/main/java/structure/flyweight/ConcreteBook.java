package structure.flyweight;

/**
 * @description: 具体享元类
 * @author: dingwei17@jd.com
 * @date : 2023/8/9 19:52
 */
public class ConcreteBook implements Book {
    /**
     * 被借出的书名
     */
    private String name;

    public ConcreteBook(String name) {
        this.name = name;
    }

    @Override
    public void borrow() {
        System.out.println("图书馆借出一本书,书名:" + this.name);
    }
}
