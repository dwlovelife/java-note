package behavior.memento;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 管理者类
 * @author: dingwei17@jd.com
 * @date : 2023/8/8 14:33
 */
@Data
public class Caretaker {

    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }

}
