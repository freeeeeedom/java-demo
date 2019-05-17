package demo.designPatterns.StatePattern.state;

import demo.designPatterns.StatePattern.Context;

public interface State {
    public void doAction(Context context);
}