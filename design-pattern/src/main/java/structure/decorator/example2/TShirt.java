package structure.decorator.example2;

/**
 * @description: T恤衫
 * @author: dingwei17@jd.com
 * @date : 2023/8/8 15:17
 */
public class TShirt extends Finery {

    @Override
    public void dress() {
        System.out.println("T恤衫");
        super.dress();
    }

}
