package structure.decorator.example2;

/**
 * @description: 服饰
 * @author: dingwei17@jd.com
 * @date : 2023/8/8 15:17
 */
public class Finery {

    protected Man man;

    public Man decorate(Man man){
        this.man = man;
        return man;
    }

    public void dress(){
        if (man != null){
            man.dress();
        }
    }

}
