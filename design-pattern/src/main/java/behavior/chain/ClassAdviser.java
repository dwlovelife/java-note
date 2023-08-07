package behavior.chain;

/**
 * @description: 班主任类
 * @author: dingwei17@jd.com
 * @date : 2023/8/7 15:39
 */
public class ClassAdviser extends Leader {

    @Override
    public void handlerRequest(Integer leaveDays) {
        if (leaveDays <= 2) {
            System.out.println("班主任批准您请假:" + leaveDays + "天");
        } else {
            if (getNext() != null) {
                getNext().handlerRequest(leaveDays);
            }
        }
    }
}
