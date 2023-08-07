package behavior.command;

/**
 * @description: 灯开命令，
 * @author: dingwei17@jd.com
 * @date : 2023/8/7 18:11
 */
public class LightOnCommand implements Command{
    /**
     * 命令接受者
     */
    private final Receive receive;

    public LightOnCommand(Receive receive) {
        this.receive = receive;
    }

    @Override
    public void execute() {
        receive.turnOff();
    }
}
