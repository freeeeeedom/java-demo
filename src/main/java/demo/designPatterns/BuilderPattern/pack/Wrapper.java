package demo.designPatterns.BuilderPattern.pack;

import demo.designPatterns.Packing;

public class Wrapper implements Packing {

    @Override
    public String pack() {
        return "Wrapper";
    }
}