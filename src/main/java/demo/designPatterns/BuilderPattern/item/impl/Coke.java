package demo.designPatterns.BuilderPattern.item.impl;

import demo.designPatterns.BuilderPattern.item.ColdDrink;

public class Coke extends ColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}