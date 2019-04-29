package demo.design.BuilderPattern.item;

import demo.design.BuilderPattern.pack.Bottle;
import demo.design.Item;
import demo.design.Packing;

public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}