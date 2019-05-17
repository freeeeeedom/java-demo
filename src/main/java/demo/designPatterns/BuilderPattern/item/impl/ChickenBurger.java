package demo.designPatterns.BuilderPattern.item.impl;

import demo.designPatterns.BuilderPattern.item.Burger;

public class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}