package demo.design.BuilderPattern.pack;

import demo.design.Packing;

public class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }
}