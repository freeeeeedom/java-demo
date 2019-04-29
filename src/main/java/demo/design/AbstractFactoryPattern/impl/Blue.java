package demo.design.AbstractFactoryPattern.impl;

import demo.design.Color;

public class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}