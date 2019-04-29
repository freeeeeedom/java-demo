package demo.design.StatePattern.state;

import demo.design.StatePattern.Context;

public interface State {
    public void doAction(Context context);
}