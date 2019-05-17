package demo.designPatterns.ObserverPattern.observers.impl;

import demo.designPatterns.ObserverPattern.observers.Observer;
import demo.designPatterns.ObserverPattern.subject.Subject;


public class S_Observer extends Observer {

    public S_Observer(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Second");
    }
}
