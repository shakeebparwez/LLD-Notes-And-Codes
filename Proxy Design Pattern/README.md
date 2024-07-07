### Proxy Design Pattern

The Proxy Design Pattern is a structural design pattern that provides an object that acts as a substitute or placeholder for another object. A proxy controls access to the original object, allowing you to perform some operations before or after the request gets to the original object.

### Key Concepts

- **Subject**: An interface or abstract class that defines the common interface for the real subject and the proxy.
- **RealSubject**: The class that implements the Subject interface and defines the actual business logic.
- **Proxy**: The class that implements the Subject interface and controls access to the RealSubject. The proxy can perform operations such as access control, lazy initialization, logging, etc.

### When to Use

- **Access Control**: To control access to an object.
- **Lazy Initialization**: To defer the creation and initialization of expensive objects until needed.
- **Logging and Monitoring**: To add logging or monitoring before/after the real object is accessed.
- **Remote Proxy**: To act as a local representative for an object in a different address space.

### UML Diagram

```
+-----------+     +----------+
|  Subject  |<----|  Client  |
+-----------+     +----------+
     ^                 |
     |                 |
+------------+    +----------------+
| RealSubject|    |      Proxy     |
+------------+    +----------------+
| +request() |    | +request()     |
+------------+    +----------------+
                      |     ^
                      v     |
                 +-----------------+
                 |  RealSubject    |
                 +-----------------+
                 | +request()      |
                 +-----------------+
```

### Example: Image Viewer

Imagine you have an application that displays images. Loading high-resolution images can be resource-intensive, so you want to use a proxy to load images on demand.

**Subject Interface:**
```java
public interface Image {
    void display();
}
```

**RealSubject (HighResolutionImage):**
```java
public class HighResolutionImage implements Image {
    private String fileName;

    public HighResolutionImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}
```

**Proxy (ProxyImage):**
```java
public class ProxyImage implements Image {
    private HighResolutionImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new HighResolutionImage(fileName);
        }
        realImage.display();
    }
}
```

**Client Code:**
```java
public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_image.jpg");

        // Image will be loaded from disk
        image.display();

        // Image will not be loaded from disk, it will be displayed directly
        image.display();
    }
}
```

### Explanation:
1. **Image (Subject)**:
   - An interface that defines the method for displaying an image.

2. **HighResolutionImage (RealSubject)**:
   - A class that implements the Image interface and defines the actual logic for loading and displaying an image.

3. **ProxyImage (Proxy)**:
   - A class that implements the Image interface and controls access to the HighResolutionImage. It loads the image on demand and delegates the display request to the real image.

4. **Client Code**:
   - Demonstrates how to use the ProxyImage to load and display images.

### Advantages:
- **Control Over Object**: Provides controlled access to the real object.
- **Lazy Initialization**: Defers the creation and initialization of expensive objects until needed.
- **Logging/Monitoring**: Can add additional functionality like logging, monitoring, and access control.

### Disadvantages:
- **Overhead**: Introduces an additional layer of indirection, which can add complexity and overhead.
- **Complexity**: Can make the code more complex to understand and maintain.

This example demonstrates how the Proxy pattern can be used to control access to an object and defer its initialization. Let me know if you have any more questions or need further clarification!