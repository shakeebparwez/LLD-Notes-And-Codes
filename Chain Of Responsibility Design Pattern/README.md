### Chain of Responsibility Design Pattern

The Chain of Responsibility Design Pattern is a behavioral design pattern that allows an object to pass a request along a chain of potential handlers until the request is handled. Each handler in the chain either processes the request or passes it to the next handler in the chain.

### Key Concepts

- **Handler**: Defines an interface for handling requests and an optional reference to the next handler in the chain.
- **ConcreteHandler**: Implements the handler interface and processes requests it is responsible for. It can forward requests to the next handler if necessary.
- **Client**: Initiates the request and forwards it to the first handler in the chain.

### When to Use

- You want to decouple the sender of a request from its receivers.
- More than one object may handle a request, and the handler isn’t known a priori.
- You want to issue a request to one of several objects without specifying the receiver explicitly.
- The set of objects that can handle a request should be specified dynamically.

### UML Diagram

```
+-------------------+
|     Handler       |
+-------------------+
| +setNext(handler) |
| +handle(request)  |
+-------------------+
        ^
        |
+---------------------+
|   ConcreteHandler1  |
+---------------------+
| +handle(request)    |
+---------------------+
        ^
        |
+---------------------+
|   ConcreteHandler2  |
+---------------------+
| +handle(request)    |
+---------------------+
```

### Example: Logging System

Imagine a logging system where logs can have different levels (INFO, DEBUG, ERROR). Each log level should be handled by a different handler, but if one handler cannot process the request, it should pass it to the next handler in the chain.

**Handler Interface:**
```java
public abstract class Logger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    protected abstract void write(String message);
}
```

**ConcreteHandler1 (ConsoleLogger):**
```java
public class ConsoleLogger extends Logger {
    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
```

**ConcreteHandler2 (ErrorLogger):**
```java
public class ErrorLogger extends Logger {
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
```

**ConcreteHandler3 (FileLogger):**
```java
public class FileLogger extends Logger {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
```

**Client Code:**
```java
public class ChainPatternDemo {
    private static Logger getChainOfLoggers() {
        Logger errorLogger = new ErrorLogger(Logger.ERROR);
        Logger fileLogger = new FileLogger(Logger.DEBUG);
        Logger consoleLogger = new ConsoleLogger(Logger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        Logger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(Logger.INFO, "This is an information.");
        loggerChain.logMessage(Logger.DEBUG, "This is a debug level information.");
        loggerChain.logMessage(Logger.ERROR, "This is an error information.");
    }
}
```

### Explanation:
1. **Logger (Handler)**:
   - An abstract class that defines the structure for handling requests. It has a method to set the next logger in the chain and a method to log messages.

2. **ConsoleLogger, ErrorLogger, FileLogger (ConcreteHandlers)**:
   - Concrete classes that extend the Logger class and implement the write method to handle specific log levels.

3. **Client Code**:
   - Sets up the chain of loggers and passes requests to the chain.

### Advantages:
- **Decoupling**: Reduces the coupling between the sender and receiver of a request.
- **Flexibility**: Allows dynamic changes in the handling of requests by changing the chain of handlers.
- **Responsibility Sharing**: The handling of requests is shared among multiple handlers.

### Disadvantages:
- **No Guarantee of Handling**: There’s no guarantee that a request will be handled if no suitable handler is found in the chain.
- **Complexity**: Can introduce complexity with long chains of handlers.

This example demonstrates how the Chain of Responsibility pattern can be used to create a flexible and decoupled logging system. Let me know if you have any more questions or need further clarification!