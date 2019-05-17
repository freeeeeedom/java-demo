package demo.design.ObserverPattern.observers.impl;

import demo.design.ObserverPattern.observers.Observer;
import demo.design.ObserverPattern.subject.Subject;


public class S_Observer extends Observer {

    public S_Observer(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Second");
    }
}
