package demo.design.ObserverPattern.observers.impl;

import demo.design.ObserverPattern.observers.Observer;
import demo.design.ObserverPattern.subject.Subject;


public class T_Observer extends Observer {
    public T_Observer(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("third");
    }
}
