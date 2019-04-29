package demo.design.BuilderPattern.item.impl;

import demo.design.BuilderPattern.item.ColdDrink;

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