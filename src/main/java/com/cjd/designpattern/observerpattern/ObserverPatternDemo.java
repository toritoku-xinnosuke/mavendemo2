package com.cjd.designpattern.observerpattern;

//观察者模式 我的理解是一个类绑定了自己的观察者，观察者在初始化的时候会注册进来
//这个类的某个需要被观察的方法被触发的时候，调用自己的通知方法通知所有的观察者
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}