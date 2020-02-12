package priciple.inversion.improve;


public class DependencyInversion {
    public static void main(String[] args) {
        //客户端无需改变
        Person person1 = new Person();
        person1.receive(new Email());
        Person person2 = new Person();
        person2.receive(new WeiXin());
    }
}

//定义接口
interface IReceiver {
    public String getInfo();
}

class Email implements IReceiver {
    public String getInfo() {
        return "电子邮件信息,hello,world";
    }
}
//增加微信
class WeiXin implements IReceiver {
    public String getInfo(){
        return "微信信息: hello,ok";
    }
}

//完成Person接收消息功能
//方式1分析
//1.简单，比较容易想到
//2.如果我们获取的对象是微信
class Person {
    public void receive(IReceiver message) {
        System.out.println(message.getInfo());
    }
}
