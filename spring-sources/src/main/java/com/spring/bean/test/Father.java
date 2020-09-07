package com.spring.bean.test;


public class Father extends Son {

    public static void main(String[] args) {
        Father father = new Father();
        father.helpSon();

    }

    public void helpSon(){
        System.out.println("帮助son做某事");
        super.doSomething();
    }

    @Override
    public void playGame(){
        System.out.println("英雄联盟");
    }

}
