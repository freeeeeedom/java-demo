package demo.design.BuilderPattern.item;

import demo.design.BuilderPattern.pack.Wrapper;
import demo.design.Item;
import demo.design.Packing;

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}