The Decorator Design Pattern is a structural pattern that allows behavior to be added to individual objects, either statically or dynamically, without affecting the behavior of other objects from the same class. It involves a set of decorator classes that are used to wrap concrete components.

### Key Concepts

- **Component**: The interface or abstract class defining the object being decorated.
- **ConcreteComponent**: The class that implements the Component interface. This is the object to which additional responsibilities can be added.
- **Decorator**: The abstract class that implements the Component interface and contains a reference to a Component object.
- **ConcreteDecorator**: The class that extends the Decorator class and adds responsibilities to the Component.

### When to Use

- You want to add responsibilities to individual objects, not to an entire class.
- You want to add behavior at runtime that can be withdrawn.
- Inheritance is impractical; for example, if you want to add functionalities to a class but don’t want to create subclasses for every possible combination of behaviors.

### UML Diagram

```
          +-------------------+
          |     Component     |
          +-------------------+
          | +operation()      |
          +-------------------+
                   ^
                   |
          +-------------------+
          |ConcreteComponent  |
          +-------------------+
          | +operation()      |
          +-------------------+
                   ^
                   |
          +-------------------+
          |     Decorator     |
          +-------------------+
          | -component:       |
          |   Component       |
          | +operation()      |
          +-------------------+
                   ^
                   |
          +-------------------+
          |ConcreteDecoratorA |
          +-------------------+
          | +operation()      |
          | +addedBehavior()  |
          +-------------------+
                   ^
                   |
          +-------------------+
          |ConcreteDecoratorB |
          +-------------------+
          | +operation()      |
          | +addedBehavior()  |
          +-------------------+
```

### Example: Coffee Shop

Imagine a coffee shop where you can order a coffee and add various condiments (like milk, sugar, etc.) to it. Each condiment should be added dynamically without modifying the Coffee class.

**Component Interface:**
```java
public interface Coffee {
    double cost();
    String description();
}
```

**ConcreteComponent:**
```java
public class SimpleCoffee implements Coffee {
    @Override
    public double cost() {
        return 5.0;
    }

    @Override
    public String description() {
        return "Simple Coffee";
    }
}
```

**Decorator:**
```java
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    public double cost() {
        return decoratedCoffee.cost();
    }

    public String description() {
        return decoratedCoffee.description();
    }
}
```

**ConcreteDecoratorA (Milk):**
```java
public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.cost() + 1.5;
    }

    @Override
    public String description() {
        return super.description() + ", Milk";
    }
}
```

**ConcreteDecoratorB (Sugar):**
```java
public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.cost() + 0.5;
    }

    @Override
    public String description() {
        return super.description() + ", Sugar";
    }
}
```

**Client Code:**
```java
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println(simpleCoffee.description() + " $" + simpleCoffee.cost());

        Coffee milkCoffee = new MilkDecorator(new SimpleCoffee());
        System.out.println(milkCoffee.description() + " $" + milkCoffee.cost());

        Coffee milkAndSugarCoffee = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.println(milkAndSugarCoffee.description() + " $" + milkAndSugarCoffee.cost());
    }
}
```

### Explanation:
1. **Component (Coffee)**:
   - The interface for objects that can have responsibilities added to them dynamically.

2. **ConcreteComponent (SimpleCoffee)**:
   - The base class that implements the Component interface. It represents a simple coffee without any condiments.

3. **Decorator (CoffeeDecorator)**:
   - The abstract class that implements the Component interface and contains a reference to a Component object. It forwards all requests to the component object.

4. **ConcreteDecoratorA (MilkDecorator)**:
   - Extends the Decorator class and adds functionality (milk) to the component.

5. **ConcreteDecoratorB (SugarDecorator)**:
   - Extends the Decorator class and adds functionality (sugar) to the component.

6. **Client Code**:
   - Demonstrates how to use decorators to add responsibilities to the coffee dynamically.

### Advantages:
- **Flexibility**: More flexible than inheritance. Allows behavior to be added or removed at runtime.
- **Single Responsibility Principle**: You can divide a class into a series of decorator classes, each of which focuses on a single concern.
- **Open/Closed Principle**: You can introduce new functionality without altering existing classes.

### Disadvantages:
- **Complexity**: Can result in a large number of small classes that can be harder to manage and understand.
- **Overhead**: The use of multiple layers of decorators can add complexity and performance overhead to your application.

This example demonstrates how the Decorator Pattern can be used to add responsibilities to objects dynamically, providing greater flexibility and adhering to the open/closed principle.