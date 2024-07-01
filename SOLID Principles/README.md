SOLID is an acronym that represents five basic principles of object-oriented design and programming. These principles help developers create code that is easier to maintain, understand, and extend. Here's a brief overview of each principle:

### 1. Single Responsibility Principle (SRP)
**Definition**: A class should have only one reason to change, meaning it should have only one job or responsibility.

**Example**:
```java
class Book {
    private String title;
    private String author;

    // Constructor, getters, and setters
    public void printBook() {
        // Responsibility of printing the book
        System.out.println("Title: " + title + ", Author: " + author);
    }
}
```
*In this example, the `Book` class has the responsibility of representing a book and printing its details. If printing logic changes, it will affect this class.*

### 2. Open/Closed Principle (OCP)
**Definition**: Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.

**Example**:
```java
abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {
    @Override
    void draw() {
        // Drawing circle logic
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        // Drawing rectangle logic
    }
}

class Drawing {
    private List<Shape> shapes;

    public Drawing(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public void drawAllShapes() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
```
*In this example, `Shape` is an abstract class, and we can extend it to add new shapes without modifying the existing code.*

### 3. Liskov Substitution Principle (LSP)
**Definition**: Subtypes must be substitutable for their base types without altering the correctness of the program.

**Example**:
```java
class Bird {
    public void fly() {
        // General flying behavior
    }
}

class Sparrow extends Bird {
    @Override
    public void fly() {
        // Sparrow flying behavior
    }
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostriches can't fly");
    }
}
```
*In this example, `Ostrich` violates the LSP because it cannot be substituted for `Bird` without causing issues (it can't fly).*

### 4. Interface Segregation Principle (ISP)
**Definition**: Clients should not be forced to depend on interfaces they do not use. Split large interfaces into smaller, more specific ones.

**Example**:
```java
interface Flyable {
    void fly();
}

interface Walkable {
    void walk();
}

class Sparrow implements Flyable, Walkable {
    @Override
    public void fly() {
        // Sparrow flying
    }

    @Override
    public void walk() {
        // Sparrow walking
    }
}

class Ostrich implements Walkable {
    @Override
    public void walk() {
        // Ostrich walking
    }
}
```
*In this example, the `Flyable` and `Walkable` interfaces are separated so that `Ostrich` only implements `Walkable` and not `Flyable`.*

### 5. Dependency Inversion Principle (DIP)
**Definition**: High-level modules should not depend on low-level modules. Both should depend on abstractions (e.g., interfaces). Abstractions should not depend on details. Details should depend on abstractions.

**Example**:
```java
interface Keyboard {
    void type();
}

class MechanicalKeyboard implements Keyboard {
    @Override
    public void type() {
        // Mechanical keyboard typing
    }
}

class Computer {
    private Keyboard keyboard;

    public Computer(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public void type() {
        keyboard.type();
    }
}
```
*In this example, the `Computer` class depends on the `Keyboard` interface, not on a specific implementation. This allows for flexibility in changing the `Keyboard` implementation without modifying the `Computer` class.*