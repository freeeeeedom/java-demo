package demo.designPatterns.BuilderPattern.pack;

import demo.designPatterns.Packing;

public class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }
}