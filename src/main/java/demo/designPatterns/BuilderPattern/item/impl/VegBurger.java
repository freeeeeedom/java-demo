package demo.designPatterns.BuilderPattern.item.impl;

import demo.designPatterns.BuilderPattern.item.Burger;

public class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
