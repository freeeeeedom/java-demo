package demo.designPatterns.BuilderPattern.item.impl;

import demo.designPatterns.BuilderPattern.item.ColdDrink;

public class Pepsi extends ColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}