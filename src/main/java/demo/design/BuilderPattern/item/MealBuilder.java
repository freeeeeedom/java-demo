package demo.design.BuilderPattern.item;

import demo.design.BuilderPattern.item.impl.ChickenBurger;
import demo.design.BuilderPattern.item.impl.Coke;
import demo.design.BuilderPattern.item.impl.Pepsi;
import demo.design.BuilderPattern.item.impl.VegBurger;

public class MealBuilder {

    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}