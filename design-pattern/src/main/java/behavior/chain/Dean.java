package behavior.chain;

/**
 * @description: 院长类
 * @author: dingwei17@jd.com
 * @date : 2023/8/7 16:42
 */
public class Dean extends Leader {

    @Override
    public void handlerRequest(Integer leaveDays) {
        if (leaveDays < 10) {
            System.out.println("院长批准您请假:" + leaveDays + "天");
        } else {
            if (getNext() != null) {
                getNext().handlerRequest(leaveDays);
            }
        }
    }

}
