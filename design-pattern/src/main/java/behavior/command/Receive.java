package behavior.command;

/**
 * @description: 接收者
 * @author: dingwei17@jd.com
 * @date : 2023/8/7 17:49
 */
public class Receive {

    /**
     * 开
     */
    public void turnOn() {
        System.out.println("执行开灯操作");
    }

    /**
     * 执行关灯操作
     */
    public void turnOff() {
        System.out.println("执行关灯操作");
    }

}
