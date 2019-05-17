package demo.designPatterns.BuilderPattern.item;

import demo.designPatterns.BuilderPattern.pack.Wrapper;
import demo.designPatterns.Item;
import demo.designPatterns.Packing;

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}