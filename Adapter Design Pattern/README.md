### Adapter Design Pattern

The Adapter Design Pattern is a structural design pattern that allows objects with incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces by converting the interface of a class into another interface that a client expects.

### Key Concepts

- **Target**: An interface that the client expects.
- **Adapter**: A class that implements the Target interface and adapts the Adaptee to the Target interface.
- **Adaptee**: A class that has an incompatible interface with the Target.
- **Client**: A class that interacts with objects using the Target interface.

### When to Use

- When you want to use an existing class, but its interface is not compatible with the interface you need.
- When you want to create a reusable class that cooperates with classes that do not have compatible interfaces.

### UML Diagram

```
+--------------+          +--------------+
|    Client    |          |   Target     |
+--------------+          +--------------+
       |                         ^
       |                         |
       v                         |
+--------------+          +--------------+
|   Adapter    |--------->|   Adaptee    |
+--------------+          +--------------+
| -adaptee: Adaptee|      | +specificRequest() |
| +request()       |      +--------------+
+--------------+          
```

### Example: Media Player

Consider a scenario where you have an advanced media player that can play different types of audio files (e.g., VLC, MP4) and a standard media player interface that can only play MP3 files. You need to adapt the advanced media player to the standard media player interface.

**Target Interface (MediaPlayer):**
```java
public interface MediaPlayer {
    void play(String audioType, String fileName);
}
```

**Adaptee (AdvancedMediaPlayer):**
```java
public interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}

public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // Do nothing
    }
}

public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        // Do nothing
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}
```

**Adapter (MediaAdapter):**
```java
public class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}
```

**Client (AudioPlayer):**
```java
public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        // inbuilt support to play mp3 music files
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name: " + fileName);
        }
        // mediaAdapter is providing support to play other file formats
        else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}
```

**Client Code:**
```java
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
```

### Explanation:
1. **MediaPlayer (Target Interface)**:
   - Defines the interface that the client expects to interact with.

2. **AdvancedMediaPlayer (Adaptee Interface)**:
   - Defines the interface for the advanced media player that can play different types of audio files.

3. **VlcPlayer and Mp4Player (Adaptees)**:
   - Implement the AdvancedMediaPlayer interface to play VLC and MP4 files, respectively.

4. **MediaAdapter (Adapter)**:
   - Implements the MediaPlayer interface and adapts the AdvancedMediaPlayer to the MediaPlayer interface.

5. **AudioPlayer (Client)**:
   - Uses the MediaPlayer interface to play different types of audio files and uses MediaAdapter to adapt the advanced media player to the standard media player interface.

### Advantages:
- **Single Responsibility Principle**: Separates the interface or data conversion code from the main business logic.
- **Open/Closed Principle**: New adapters can be introduced without changing existing code.

### Disadvantages:
- **Complexity**: The pattern can introduce additional layers of complexity.

This example demonstrates how the Adapter pattern can be used to adapt an advanced media player to a standard media player interface, allowing them to work together seamlessly. Let me know if you have any more questions or need further clarification!