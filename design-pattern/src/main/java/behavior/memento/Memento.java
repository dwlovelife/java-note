package behavior.memento;

/**
 * @description: 备忘录类
 * @author: dingwei17@jd.com
 * @date : 2023/8/8 14:13
 */
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState() {
        this.state = state;
    }

}
