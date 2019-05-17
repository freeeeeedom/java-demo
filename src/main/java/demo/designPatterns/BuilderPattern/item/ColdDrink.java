package demo.designPatterns.BuilderPattern.item;

import demo.designPatterns.BuilderPattern.pack.Bottle;
import demo.designPatterns.Item;
import demo.designPatterns.Packing;

public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}