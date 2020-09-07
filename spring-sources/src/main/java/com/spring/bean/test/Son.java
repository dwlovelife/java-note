package com.spring.bean.test;


abstract class Son {

    final private String fristName = "Smith";

    public void doSomething(){
        System.out.println(this.getClass());
        this.doHomeWork();
        this.playGame();
    }

    public void playGame(){
        System.out.println(this.getClass());
        System.out.println("王者榮耀");
    }
    public void doHomeWork(){
        System.out.println(this.getClass());
        System.out.println("写作业");
    }

}
