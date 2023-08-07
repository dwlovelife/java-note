package behavior.chain;

/**
 * @description: 责任链模式测试类
 * @author: dingwei17@jd.com
 * @date : 2023/8/7 16:44
 */
public class LeaveApprovalTest {

    public static void main(String[] args) {
        Leader teacher1 = new ClassAdviser();
        Leader teacher2 = new DepartmentHead();
        Leader teacher3 = new Dean();
        teacher1.setNext(teacher2);
        teacher2.setNext(teacher3);

        teacher1.handlerRequest(8);
    }

}
