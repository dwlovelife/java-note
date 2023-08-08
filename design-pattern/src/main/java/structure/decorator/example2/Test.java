package structure.decorator.example2;

/**
 * @description: 测试方法
 * @author: dingwei17@jd.com
 * @date : 2023/8/8 15:19
 */
public class Test {
    public static void main(String[] args) {
        Man xiaoMing = new Man("小明");

        //场合一：运动
        Finery sportShoes = new SportShoes();
        xiaoMing = sportShoes.decorate(xiaoMing);   //穿了运动鞋的小明
        sportShoes.dress();                 //装扮好了
        Finery tShirt = new TShirt();
        tShirt.decorate(xiaoMing);     //穿了运动鞋的小明再穿一件T恤衫
        tShirt.dress();                  //装扮好了
    }
}
