package DecoratorPattern;

import DecoratorPattern.BasePizza.BasePizza;
import DecoratorPattern.BasePizza.Margherita;
import DecoratorPattern.ToppingDecorator.ExtraCheese;
import DecoratorPattern.ToppingDecorator.Mushroom;

public class PizzaShop {
    public static void main(String[] args) {
        BasePizza pizza = new Mushroom(new ExtraCheese(new Margherita()));
        System.out.println("Margherita + ExtraCheese + Mushroom Cost: " + pizza.cost());
    }
}
