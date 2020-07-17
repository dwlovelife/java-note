package behavior.template;

/**
 * 红豆豆浆
 */
public class ReadBeanMilk extends SoyaMilk {

    @Override
    void addCondiments() {
        System.out.println("加入上好的红豆");
    }

    @Override
    boolean isAddCondiments() {
        return true;
    }

}
