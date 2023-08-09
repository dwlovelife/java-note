package behavior.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 负责调用
 * @author: dingwei17@jd.com
 * @date : 2023/8/7 18:08
 */
public class Invoke {
    /**
     * 命令清单
     */
    List<Command> commandList;

    /**
     * 执行命令
     * @param command
     */
    public void executeCommand(Command command) {
        command.execute();
    }

    /**
     * 批量执行命令
     * @param commandList
     */
    public void executeCommands(List<Command>  commandList) {
        for (Command command: commandList) {
            command.execute();
        }
    }

    /**
     * 添加命令
     * @param command
     */
    public void addCommand(Command command) {
        if (commandList == null || commandList.isEmpty()) {
            commandList = new ArrayList<>();
        }
        commandList.add(command);
    }

}
