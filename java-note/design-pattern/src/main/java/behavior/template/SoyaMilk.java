package behavior.template;


/**
 * 抽象类表示豆浆
 */
public abstract class SoyaMilk {

    /**
     * 模板方法, make, 模板方法可以制作成final,不让子类去覆盖
     */
    final void make(){
        select();
        if(isAddCondiments()){
            addCondiments();
        }
        soak();
        beat();
    }

    /**
     * 选材料
     */
    private void select(){
        System.out.println("第一步：选择上好的新鲜黄豆");
    }

    /**
     * 添加不同的配料,抽象方法,让子类去实现具体的逻辑
     */
    abstract void addCondiments();

    /**
     * 钩子方法
     */
    abstract boolean isAddCondiments();

    /**
     * 浸泡
     */
    private void soak(){
        System.out.println("第三步：黄豆和配料开始浸泡, 需要3小时");
    }

    private void beat(){
        System.out.println("第四步：用豆浆机打磨黄豆和配料");
    }


}
