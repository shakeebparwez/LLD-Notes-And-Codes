### State Design Pattern

The State Design Pattern is a behavioral design pattern that allows an object to change its behavior when its internal state changes. The pattern involves creating state objects that represent various states and a context object whose behavior varies as its state object changes.

### Key Concepts

- **Context**: Maintains an instance of a ConcreteState subclass that defines the current state.
- **State**: Defines an interface for encapsulating the behavior associated with a particular state of the Context.
- **ConcreteState**: Implements the behavior associated with a state of the Context.

### When to Use

- The behavior of an object should depend on its state, and it must change its behavior at runtime depending on that state.
- The operations have large, multipart conditional statements that depend on the object's state. Each branch of the conditional represents a state.

### UML Diagram

```
+--------------+
|   Context    |
+--------------+
| -state: State|
+--------------+
| +request()   |
+--------------+
      |
      v
+-----------------+
|     State       |
+-----------------+
| +handle(context)|
+-----------------+
      ^
      |
+-----------------+       +-----------------+
| ConcreteStateA  |       | ConcreteStateB  |
+-----------------+       +-----------------+
| +handle(context)|       | +handle(context)|
+-----------------+       +-----------------+
```

### Example: Vending Machine

Consider a vending machine that dispenses products based on user actions such as inserting money, selecting a product, and dispensing the product.

**State Interface:**
```java
public interface VendingMachineState {
    void insertMoney(VendingMachine context, int amount);
    void selectProduct(VendingMachine context, String product);
    void dispenseProduct(VendingMachine context);
}
```

**ConcreteStateA (NoMoneyState):**
```java
public class NoMoneyState implements VendingMachineState {
    @Override
    public void insertMoney(VendingMachine context, int amount) {
        System.out.println("Money inserted: " + amount);
        context.setState(new HasMoneyState());
    }

    @Override
    public void selectProduct(VendingMachine context, String product) {
        System.out.println("Insert money first.");
    }

    @Override
    public void dispenseProduct(VendingMachine context) {
        System.out.println("Insert money first.");
    }
}
```

**ConcreteStateB (HasMoneyState):**
```java
public class HasMoneyState implements VendingMachineState {
    @Override
    public void insertMoney(VendingMachine context, int amount) {
        System.out.println("Money already inserted.");
    }

    @Override
    public void selectProduct(VendingMachine context, String product) {
        System.out.println("Product selected: " + product);
        context.setState(new ProductSelectedState());
    }

    @Override
    public void dispenseProduct(VendingMachine context) {
        System.out.println("Select a product first.");
    }
}
```

**ConcreteStateC (ProductSelectedState):**
```java
public class ProductSelectedState implements VendingMachineState {
    @Override
    public void insertMoney(VendingMachine context, int amount) {
        System.out.println("Money already inserted and product selected.");
    }

    @Override
    public void selectProduct(VendingMachine context, String product) {
        System.out.println("Product already selected.");
    }

    @Override
    public void dispenseProduct(VendingMachine context) {
        System.out.println("Dispensing product...");
        context.setState(new NoMoneyState());
    }
}
```

**Context (VendingMachine):**
```java
public class VendingMachine {
    private VendingMachineState state;

    public VendingMachine() {
        state = new NoMoneyState(); // Initial state
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public void insertMoney(int amount) {
        state.insertMoney(this, amount);
    }

    public void selectProduct(String product) {
        state.selectProduct(this, product);
    }

    public void dispenseProduct() {
        state.dispenseProduct(this);
    }
}
```

**Client Code:**
```java
public class StatePatternDemo {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.insertMoney(100);
        vendingMachine.selectProduct("Soda");
        vendingMachine.dispenseProduct();

        vendingMachine.insertMoney(50);
        vendingMachine.selectProduct("Chips");
        vendingMachine.dispenseProduct();
    }
}
```

### Explanation:
1. **VendingMachineState (State)**:
   - An interface that defines the methods for handling state-specific behavior.

2. **NoMoneyState, HasMoneyState, ProductSelectedState (ConcreteState)**:
   - Concrete classes that implement the VendingMachineState interface and provide the behavior for each state.

3. **VendingMachine (Context)**:
   - Maintains an instance of the current state and delegates state-specific behavior to the current state object.

4. **Client Code**:
   - Demonstrates how the VendingMachine changes its behavior based on its state.

### Advantages:
- **Single Responsibility Principle**: Organizes code related to particular states into separate classes.
- **Open/Closed Principle**: Adding new states doesn’t affect existing states or the context.
- **Simplifies Complex State-specific Code**: Encapsulates the state-specific behavior, making the context code simpler and more understandable.

### Disadvantages:
- **Increased Number of Classes**: Can lead to an increase in the number of classes, which might add complexity.
- **Context and State Coordination**: The context and state classes need to be coordinated carefully to ensure proper state transitions.

This example demonstrates how the State pattern can be used to manage state-specific behavior in an object. Let me know if you have any more questions or need further clarification!