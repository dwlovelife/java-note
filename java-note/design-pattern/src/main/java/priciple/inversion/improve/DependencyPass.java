package priciple.inversion.improve;

//依赖倒转原则常见的几种方式
public class DependencyPass {
    public static void main(String[] args) {
        // 方式1
        /*ChangeHong changeHong = new ChangeHong();
        OpenAndClose openAndClose = new OpenAndClose();
        openAndClose.open(changeHong);*/

        //方式2
        /*ChangHong changHong = new ChangHong();
        OpenAndClose openAndClose = new OpenAndClose(changHong);
        openAndClose.open();*/

        //方式3
        ChangHong changHong = new ChangHong();
        OpenAndClose openAndClose = new OpenAndClose();
        openAndClose.setTv(changHong);
        openAndClose.open();

    }
}

//方式1：通过接口传递实现依赖
//开关的接口
//interface IOpenAndClose {
//    public void open(ITV tv); //抽象方法,接收接口
//}
//
//interface ITV { //ITV接口
//    public void play();
//}
//
//class ChangeHong implements ITV {
//    @Override
//    public void play(){
//        System.out.println("长虹电视，打开");
//    }
//}
//
////实现接口
//class OpenAndClose implements  IOpenAndClose{
//    public void open(ITV tv){
//        tv.play();
//    }
//}

//方式2：通过构造方法依赖传递
/*
interface IOpenAndClose {
    public void open();
}

interface ITV { //ITV接口
    public void play();
}

class OpenAndClose implements IOpenAndClose{
    public ITV tv; //成员
    public OpenAndClose(ITV tv){ //构造器
        this.tv = tv;
    }
    public void open(){
        this.tv.play();
    }
}

class ChangHong implements ITV {
    @Override
    public void play(){
        System.out.println("长虹电视机,打开");
    }
}*/

//方式3 通过setter方法传递
interface ITV { // ITV接口
    public void play();
}
interface IOpenAndClose {
    public void open(); //抽象方法

    public void setTv(ITV tv);
}

class OpenAndClose implements IOpenAndClose {
    private ITV tv;

    public void setTv(ITV tv){
        this.tv = tv;
    }
    public void open() {
        this.tv.play();
    }
}
class ChangHong implements ITV {
    @Override
    public void play(){
        System.out.println("长虹电视机,打开");
    }
}
