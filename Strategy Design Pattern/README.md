The Strategy Design Pattern is one of the behavioral design patterns. It enables selecting an algorithm's behavior at runtime. Instead of implementing a single algorithm directly, code receives run-time instructions as to which in a family of algorithms to use.

### Key Concepts

- **Context**: The class that uses a `Strategy` object.
- **Strategy**: An interface common to all supported algorithms. The `Context` uses this interface to call the algorithm defined by a `ConcreteStrategy`.
- **ConcreteStrategy**: A class that implements the `Strategy` interface.

### When to Use

- You need different variants of an algorithm.
- A class defines many behaviors and switches between these behaviors using multiple conditionals.
- Algorithms are only different in behavior.

### Example: Sorting Algorithms

Suppose we have a `Sorter` class that can sort data using different algorithms.

**Strategy Interface:**
```java
public interface SortStrategy {
    void sort(int[] numbers);
}
```

**Concrete Strategies:**
```java
public class BubbleSortStrategy implements SortStrategy {
    @Override
    public void sort(int[] numbers) {
        // Bubble sort implementation
    }
}

public class QuickSortStrategy implements SortStrategy {
    @Override
    public void sort(int[] numbers) {
        // Quick sort implementation
    }
}

public class MergeSortStrategy implements SortStrategy {
    @Override
    public void sort(int[] numbers) {
        // Merge sort implementation
    }
}
```

**Context Class:**
```java
public class Sorter {
    private SortStrategy strategy;

    public Sorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] numbers) {
        strategy.sort(numbers);
    }
}
```

**Client Code:**
```java
public class StrategyPatternDemo {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 3, 1};

        // Using Bubble Sort Strategy
        Sorter sorter = new Sorter(new BubbleSortStrategy());
        sorter.sort(numbers);
        printArray(numbers);

        // Switching to Quick Sort Strategy
        sorter.setStrategy(new QuickSortStrategy());
        sorter.sort(numbers);
        printArray(numbers);

        // Switching to Merge Sort Strategy
        sorter.setStrategy(new MergeSortStrategy());
        sorter.sort(numbers);
        printArray(numbers);
    }

    private static void printArray(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
```

### Advantages

- **Open/Closed Principle**: Adding new strategies doesn’t change the context or existing strategies.
- **Single Responsibility Principle**: Encapsulates each algorithm in its class.
- **Flexibility**: Easily switch between algorithms at runtime.

### Disadvantages

- **Overhead**: More classes to maintain.
- **Complexity**: Introduces additional complexity to the code.