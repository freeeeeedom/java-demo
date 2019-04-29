package demo.design.BuilderPattern;

import demo.design.BuilderPattern.item.Meal;
import demo.design.BuilderPattern.item.MealBuilder;
/**
 * @Description: 建造者模式
 * 意图：将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示。
 * 主要解决：主要解决在软件系统中，有时候面临着"一个复杂对象"的创建工作，其通常由各个部分的子对象用一定的算法构成；
 *           由于需求的变化，这个复杂对象的各个部分经常面临着剧烈的变化，但是将它们组合在一起的算法却相对稳定。
 * 何时使用：一些基本部件不会变，而其组合经常变化的时候。
 * @author: Nevernow
 * @Date: 2019/4/26 14:56
 */
public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " +vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " +nonVegMeal.getCost());
    }
}
