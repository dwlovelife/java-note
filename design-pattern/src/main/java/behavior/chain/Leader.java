package behavior.chain;

/**
 * @description: 抽象领导类
 * @author: dingwei17@jd.com
 * @date : 2023/8/7 15:32
 */
public abstract class Leader {

    private Leader next;

    /**
     * 设置下一个责任链处理器
     * @param leader
     */
    public void setNext(Leader leader) {
        this.next = leader;
    }

    /**
     * 获取下一个责任链处理器
     * @return
     */
    public Leader getNext() {
        return next;
    }

    //处理请求的方法
    public abstract void handlerRequest(Integer leaveDays);

}
