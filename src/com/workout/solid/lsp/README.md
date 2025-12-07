# Liskov Substitution Principle (LSP) Examples

This package demonstrates the **Liskov Substitution Principle**, which is the 'L' in SOLID principles.

## Overview

The Liskov Substitution Principle states that:
> "Objects of a superclass should be replaceable with objects of its subclasses without breaking the application."

In other words, if class B is a subtype of class A, then we should be able to replace A with B without disrupting the behavior of our program.

## Package Structure

```
com.workout.solid.lsp/
├── LiskovSubProblem.java     # Demonstrates LSP violation
├── LiskovSubSolution.java    # Demonstrates LSP compliance
└── README.md                 # This documentation
```

## Files Description

### 1. LiskovSubProblem.java
- **Purpose**: Shows how LSP can be violated
- **Problem**: Square class extends Rectangle but changes behavior unexpectedly
- **Issue**: When you set width on a Square, it also changes height, breaking Rectangle's expected behavior

### 2. LiskovSubSolution.java
- **Purpose**: Shows the correct way to implement inheritance following LSP
- **Solution**: Use composition over inheritance and abstract base classes
- **Benefit**: All shape classes can be substituted for the Shape base class without issues

## Key Concepts Demonstrated

### LSP Violation (Problem)
```java
Rectangle square = new Square();
square.setWidth(5);
square.setHeight(4);
// Expected: width=5, height=4, area=20
// Actual: width=4, height=4, area=16 (LSP violated!)
```

### LSP Compliance (Solution)
```java
Shape rectangle = new RectangleShape(5, 4);
Shape square = new SquareShape(5);
// Both can be used interchangeably through Shape interface
calculateArea(rectangle); // Works correctly
calculateArea(square);    // Works correctly
```

## How to Run

### Running the Problem Example:
```bash
cd /Users/podilinaveenkumar/Offtopic/workout
javac src/com/workout/solid/lsp/LiskovSubProblem.java
java -cp src com.workout.solid.lsp.LiskovSubProblem
```

### Running the Solution Example:
```bash
cd /Users/podilinaveenkumar/Offtopic/workout
javac src/com/workout/solid/lsp/LiskovSubSolution.java
java -cp src com.workout.solid.lsp.LiskovSubSolution
```

## Coding Standards Applied

1. **Package Naming**: `com.workout.solid.lsp` follows reverse domain convention
2. **Class Naming**: PascalCase (LiskovSubProblem, LiskovSubSolution)
3. **Method Naming**: camelCase (calculateArea, demonstrateLspViolation)
4. **Documentation**: Comprehensive JavaDoc comments
5. **Code Organization**: Logical grouping of related classes
6. **Immutability**: Solution classes use final fields where appropriate
7. **Single Responsibility**: Each class has a clear, single purpose

## Learning Objectives

After reviewing these examples, you should understand:
- What the Liskov Substitution Principle means
- How to identify LSP violations in code
- How to refactor code to follow LSP
- Why LSP is important for maintainable object-oriented design
- The relationship between LSP and polymorphism

## Benefits of Following LSP

1. **Predictable Behavior**: Subclasses behave as expected
2. **Easier Testing**: You can test with base class references
3. **Better Maintainability**: Changes to subclasses don't break existing code
4. **Proper Polymorphism**: True substitutability enables powerful design patterns
