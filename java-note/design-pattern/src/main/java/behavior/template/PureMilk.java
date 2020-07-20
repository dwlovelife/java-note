package behavior.template;

/**
 * 纯豆浆
 */
public class PureMilk extends SoyaMilk{
    @Override
    void addCondiments() {}

    @Override
    boolean isAddCondiments() {
        return false;
    }
}
