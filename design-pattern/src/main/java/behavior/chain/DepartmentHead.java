package behavior.chain;

/**
 * @description: 系主任类
 * @author: dingwei17@jd.com
 * @date : 2023/8/7 15:42
 */
public class DepartmentHead extends Leader {

    @Override
    public void handlerRequest(Integer leaveDays) {
        if (leaveDays <= 7) {
            System.out.println("系主任批准您请假:" + leaveDays + "天");
        } else {
            if (getNext() != null) {
                getNext().handlerRequest(leaveDays);
            }
        }
    }

}
