package demo.designPatterns.ObserverPattern.observers;


import demo.designPatterns.ObserverPattern.subject.Subject;

public abstract class Observer {
    protected Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    public abstract void update();
}
