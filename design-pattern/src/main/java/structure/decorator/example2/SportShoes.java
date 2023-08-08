package structure.decorator.example2;

/**
 * @description: 运动鞋
 * @author: dingwei17@jd.com
 * @date : 2023/8/8 15:18
 */
public class SportShoes extends Finery {

    @Override
    public void dress() {
        System.out.println("运动鞋");
        super.dress();
    }

}
