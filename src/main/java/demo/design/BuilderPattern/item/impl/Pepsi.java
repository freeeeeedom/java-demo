package demo.design.BuilderPattern.item.impl;

import demo.design.BuilderPattern.item.ColdDrink;

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