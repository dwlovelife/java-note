package priciple.inversion;


public class DependencyInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}

class Email {
    public String getInfo() {
        return "电子邮件信息,hello,world";
    }
}
//完成Person接收消息功能
//方式1分析
//1.简单，比较容易想到
//2.如果我们获取的对象是微信
class Person {
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
}
