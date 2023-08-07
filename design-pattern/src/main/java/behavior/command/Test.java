package behavior.command;

/**
 * @description: 测试类
 * @author: dingwei17@jd.com
 * @date : 2023/8/7 18:10
 */
public class Test {
    public static void main(String[] args) {
        Receive receive = new Receive();
        Invoke invoke = new Invoke();
        LightOnCommand lightOnCommand = new LightOnCommand(receive);
        LightOffCommand lightOffCommand = new LightOffCommand(receive);
        invoke.executeCommand(lightOffCommand);
        invoke.executeCommand(lightOnCommand);
    }
}
