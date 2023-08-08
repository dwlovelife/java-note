package behavior.memento;

/**
 * @description: 发起人
 * @author: dingwei17@jd.com
 * @date : 2023/8/7 18:43
 */
public class Originator {

    /**
     * 需要保存的属性
     */
    private String state;

    /**
     * 保存一个备忘录
     * @return
     */
    public Memento saveStateToMemento(){
        return new Memento(state);
    }


    public void setStateFromMemento(Memento Memento){
        state = Memento.getState();
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
