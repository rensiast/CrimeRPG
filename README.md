# 🕵️‍♂️ Crime RPG - Detective Mystery Game

A text-based detective RPG built in Java that demonstrates core Object-Oriented Programming principles through an engaging mystery-solving experience.

## 📖 Description

**Crime RPG** is an interactive console-based game where players take on the role of a detective solving complex cases. Each case presents a unique mystery with multiple investigation paths, clues to uncover, and critical decisions that affect the outcome. The game features three distinct cases with varying difficulty levels, providing hours of engaging gameplay.

### 🎯 Features

- **Three Unique Cases**: Crimson Spotlight (Easy), Midnight Stalker (Medium), Vanishing Act (Hard)
- **Multiple Endings**: Your choices directly impact case outcomes
- **Resource Management**: Manage hearts (health) and coins (for hints)
- **Branching Storylines**: Different investigation paths lead to varied discoveries
- **Color-coded Interface**: Easy-to-read terminal with visual cues

## 🏗️ OOP Concepts Demonstrated

### 1. **Encapsulation**

```java
public class Player {
    private final String name;
    private int hearts;
    private int coins = 50;

    // Controlled access through public methods
    public void loseHeart() {
        if (hearts > 0) hearts--;  // Validation logic encapsulated
    }
}
```

- Private fields prevent direct external access

- Public getters/setters provide controlled access

- Business logic (like coin validation) encapsulated within classes

### 2. **Inheritance**

```java
public abstract class Case {
    protected String title;
    protected String description;
    // Common structure for all cases
}

public class CrimsonSpotlightCase extends Case {
    // Inherits from Case and adds specific behavior
}
```

- Base **Case** class defines common structure

- Child classes (**CrimsonSpotlightCase**, **MidnightStalkerCase**, **VanishingActCase**) extend functionality

- Code reusability through shared properties and methods

### 3. **Polymorphism**

```java
Case selectedCase = new CrimsonSpotlightCase();
selectedCase.playCase(player, scanner);
```

- Same interface (**playCase()**) with different implementations

- Runtime flexibility - game loop works with abstract Case type

- Easy extensibility - new cases can be added without modifying existing code

### 4. **Abstraction**

```java
public abstract class Case {
    public abstract void playCase(Player player, Scanner scanner);
    // Defines WHAT without specifying HOW
}
```

- Abstract classes define contracts

- Implementation details hidden from game loop

### 5. **Exception Handling**

```java
try {
    difficulty = Integer.parseInt(scanner.nextLine().trim());
} catch (NumberFormatException e) {
    System.out.println("Invalid input. Enter 1, 2, or 3.");
}
```

- Input validation throughout the game

- Graceful error recovery instead of crashes

- User-friendly error messages guide proper input

## 🗂️ Project Structure

```
CrimeRPG/
├── CrimeRPGConsole.java     # Main game launcher and loop
├── Player.java              # Player class with state management
├── Case.java                # Abstract base case class
├── CrimsonSpotlightCase.java # Easy difficulty case
├── MidnightStalkerCase.java  # Medium difficulty case
├── VanishingActCase.java     # Hard difficulty case
├── ColorUtil.java           # Terminal color utilities
└── README.md                # Project documentation
```

## Game Instructions

1.  Enter your detective name when prompted

2.  Choose a case from the available options:

        1 - Crimson Spotlight (Easy): Celebrity stalker mystery

        2 - Midnight Stalker (Medium): Campus stalker investigation

        3 - Vanishing Act (Hard): Missing person financial mystery

3.  Follow the story prompts and make investigation choices

4.  Type 'hint' during choices to spend coins for clues

5.  Manage your resources - hearts represent your health, coins for hints

6.  Solve the case by making the right investigative decisions!

## 🎮 Gameplay Features

- Multiple Difficulty Levels: Each case offers different challenge levels

- Hint System: Spend coins to get clues when stuck

- Consequence System: Wrong choices cost hearts, affecting your success

- Replayability: Different choices lead to varied outcomes

- Continuous Game Loop: Play multiple cases without restarting

## 👨‍💻 Authors

- **Molijon, Mark Dave V.**

- **Orlanes, Kit Brendan G.**

- **Pateña, Kersten Therese R.**

- **Ramirez, Justine M.**

## Acknowledgements

We would like to express our sincere gratitude to our **Professor Jayson Abratique** for his guidance, support, and encouragement throughout the course of CS 211. His insights and expertise greatly contributed to the completion of this project, and we are truly thankful for the knowledge and skills we have gained under his instruction.

**Happy Detective Work!** 🕵️‍♀️🔍
