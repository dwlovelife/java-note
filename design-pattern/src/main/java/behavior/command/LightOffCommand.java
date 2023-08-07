package behavior.command;

/**
 * @description: 灯关闭的命令
 * @author: dingwei17@jd.com
 * @date : 2023/8/7 17:48
 */
public class LightOffCommand implements Command {

    private Receive receive;

    public LightOffCommand(Receive receive) {
        this.receive = receive;
    }

    @Override
    public void execute() {
        receive.turnOff();
    }
}
