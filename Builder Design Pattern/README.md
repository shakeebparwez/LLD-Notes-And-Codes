### Builder Design Pattern

The Builder Design Pattern is a creational design pattern that allows constructing complex objects step by step. It separates the construction of a complex object from its representation, enabling the same construction process to create different representations.

### Key Concepts

- **Builder**: An interface or abstract class that defines the steps required to build the product.
- **ConcreteBuilder**: A class that implements the Builder interface and constructs the parts of the product.
- **Director**: A class that controls the construction process using a Builder instance.
- **Product**: The complex object that is being built.

### When to Use

- When you want to construct a complex object in multiple steps.
- When you want to construct different representations of a complex object.
- When the construction process must allow different implementations of the product’s parts.

### UML Diagram

```
+------------+
|  Director  |
+------------+
| -builder: Builder |
| +construct()      |
+------------+
      ^
      |
      v
+------------+             +------------+
|  Builder   |<------------|  ConcreteBuilder |
+------------+             +------------+
| +buildPartA()            | +buildPartA()     |
| +buildPartB()            | +buildPartB()     |
| +getResult()             | +getResult()      |
+------------+             +------------+
       |
       v
+----------------+
|    Product     |
+----------------+
| +setPartA()    |
| +setPartB()    |
+----------------+
```

### Example: Building a House

Consider an example where we need to build different types of houses (e.g., Igloo, Tipi) using a step-by-step approach.

**Product (House):**
```java
public class House {
    private String foundation;
    private String structure;
    private String roof;

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    @Override
    public String toString() {
        return "House built with: Foundation - " + foundation + ", Structure - " + structure + ", Roof - " + roof;
    }
}
```

**Builder Interface:**
```java
public interface HouseBuilder {
    void buildFoundation();
    void buildStructure();
    void buildRoof();
    House getHouse();
}
```

**ConcreteBuilder (IglooBuilder):**
```java
public class IglooBuilder implements HouseBuilder {
    private House house;

    public IglooBuilder() {
        this.house = new House();
    }

    @Override
    public void buildFoundation() {
        house.setFoundation("Ice Blocks");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Ice Bricks");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Ice Dome");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}
```

**ConcreteBuilder (TipiBuilder):**
```java
public class TipiBuilder implements HouseBuilder {
    private House house;

    public TipiBuilder() {
        this.house = new House();
    }

    @Override
    public void buildFoundation() {
        house.setFoundation("Wooden Poles");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Canvas");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Canvas Covering");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}
```

**Director:**
```java
public class CivilEngineer {
    private HouseBuilder houseBuilder;

    public CivilEngineer(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House constructHouse() {
        this.houseBuilder.buildFoundation();
        this.houseBuilder.buildStructure();
        this.houseBuilder.buildRoof();
        return this.houseBuilder.getHouse();
    }
}
```

**Client Code:**
```java
public class BuilderPatternDemo {
    public static void main(String[] args) {
        HouseBuilder iglooBuilder = new IglooBuilder();
        CivilEngineer engineer1 = new CivilEngineer(iglooBuilder);

        House iglooHouse = engineer1.constructHouse();
        System.out.println("House is: " + iglooHouse);

        HouseBuilder tipiBuilder = new TipiBuilder();
        CivilEngineer engineer2 = new CivilEngineer(tipiBuilder);

        House tipiHouse = engineer2.constructHouse();
        System.out.println("House is: " + tipiHouse);
    }
}
```

### Explanation:

1. **House (Product)**:
   - Represents the complex object that is being built. It has methods to set its parts (foundation, structure, roof).

2. **HouseBuilder (Builder Interface)**:
   - Defines the steps required to build the product. It includes methods to build the foundation, structure, and roof, as well as a method to get the final product.

3. **IglooBuilder and TipiBuilder (ConcreteBuilders)**:
   - Implement the HouseBuilder interface to build specific types of houses (Igloo and Tipi). Each ConcreteBuilder constructs the parts of the house and returns the final product.

4. **CivilEngineer (Director)**:
   - Controls the construction process using a Builder instance. It calls the build methods in a specific sequence to construct the house.

5. **Client Code**:
   - Demonstrates how to create different types of houses using the Builder pattern. It creates instances of ConcreteBuilders, passes them to the Director, and constructs the houses.

### Advantages:

- **Control Over Construction Process**: Provides control over the construction process.
- **Step-by-Step Construction**: Constructs objects step by step, allowing for better control and customization.
- **Different Representations**: Allows creating different representations of an object using the same construction process.

### Disadvantages:

- **Complexity**: Introduces additional classes and complexity.
- **Overhead**: May add overhead if the construction process is simple and doesn't require a builder.

This example demonstrates how the Builder pattern can be used to construct complex objects step by step, allowing for different representations using the same construction process. Let me know if you have any more questions or need further clarification!
