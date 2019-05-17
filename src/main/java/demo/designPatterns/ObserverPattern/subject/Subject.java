package demo.designPatterns.ObserverPattern.subject;

import demo.designPatterns.ObserverPattern.observers.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        observers.parallelStream().forEach(observer -> observer.update());
    }
}
