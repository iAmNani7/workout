package com.workout.solid.lsp;

/**
 * Demonstration of Liskov Substitution Principle (LSP) Solution
 *
 * This class demonstrates the correct implementation following LSP where
 * subclasses can be substituted for their parent class without breaking functionality.
 *
 * @author Workout Team
 * @version 1.0
 * @since 2025-12-07
 */
public class LiskovSubSolution {

    /**
     * Main method to demonstrate LSP compliance
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== Liskov Substitution Principle - Solution Demonstration ===");

        demonstrateLspCompliance();
    }

    /**
     * Demonstrates proper implementation following the Liskov Substitution Principle
     */
    private static void demonstrateLspCompliance() {
        System.out.println("\n--- LSP Compliant Example ---");

        // Using different shape implementations
        Shape rectangle = new RectangleShape(5, 4);
        Shape square = new SquareShape(5);

        System.out.println("Rectangle: " + rectangle);
        System.out.println("Square: " + square);

        // Both can be used interchangeably through the Shape interface
        calculateAndPrintArea(rectangle);
        calculateAndPrintArea(square);

        // Demonstrating polymorphic behavior
        Shape[] shapes = {
            new RectangleShape(3, 7),
            new SquareShape(4),
            new RectangleShape(2, 9)
        };

        System.out.println("\nPolymorphic behavior test:");
        for (Shape shape : shapes) {
            calculateAndPrintArea(shape);
        }
    }

    /**
     * Calculates and prints area for any shape
     * This method works correctly with any Shape implementation
     *
     * @param shape the shape to calculate area for
     */
    private static void calculateAndPrintArea(Shape shape) {
        System.out.println("Shape: " + shape.getClass().getSimpleName() +
                          ", Area: " + shape.calculateArea());
    }

    /**
     * Abstract base class for all shapes
     * Defines the contract that all shapes must follow
     */
    abstract static class Shape {

        /**
         * Calculates the area of the shape
         *
         * @return the area of the shape
         */
        public abstract double calculateArea();

        /**
         * Gets the perimeter of the shape
         *
         * @return the perimeter of the shape
         */
        public abstract double calculatePerimeter();

        /**
         * Checks if the shape is valid (has positive dimensions)
         *
         * @return true if the shape is valid, false otherwise
         */
        public abstract boolean isValid();
    }

    /**
     * Rectangle implementation that follows LSP
     * Can be substituted for Shape without breaking functionality
     */
    static class RectangleShape extends Shape {
        private final double width;
        private final double height;

        /**
         * Constructor for Rectangle
         *
         * @param width the width of the rectangle
         * @param height the height of the rectangle
         */
        public RectangleShape(double width, double height) {
            this.width = width;
            this.height = height;
        }

        /**
         * Gets the width of the rectangle
         *
         * @return the width
         */
        public double getWidth() {
            return width;
        }

        /**
         * Gets the height of the rectangle
         *
         * @return the height
         */
        public double getHeight() {
            return height;
        }

        @Override
        public double calculateArea() {
            return width * height;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * (width + height);
        }

        @Override
        public boolean isValid() {
            return width > 0 && height > 0;
        }

        @Override
        public String toString() {
            return String.format("Rectangle[width=%.2f, height=%.2f, area=%.2f]",
                               width, height, calculateArea());
        }
    }

    /**
     * Square implementation that follows LSP
     * Can be substituted for Shape without breaking functionality
     */
    static class SquareShape extends Shape {
        private final double side;

        /**
         * Constructor for Square
         *
         * @param side the side length of the square
         */
        public SquareShape(double side) {
            this.side = side;
        }

        /**
         * Gets the side length of the square
         *
         * @return the side length
         */
        public double getSide() {
            return side;
        }

        @Override
        public double calculateArea() {
            return side * side;
        }

        @Override
        public double calculatePerimeter() {
            return 4 * side;
        }

        @Override
        public boolean isValid() {
            return side > 0;
        }

        @Override
        public String toString() {
            return String.format("Square[side=%.2f, area=%.2f]",
                               side, calculateArea());
        }
    }

    /**
     * Circle implementation to show extensibility
     * Also follows LSP and can be substituted for Shape
     */
    static class CircleShape extends Shape {
        private final double radius;

        /**
         * Constructor for Circle
         *
         * @param radius the radius of the circle
         */
        public CircleShape(double radius) {
            this.radius = radius;
        }

        /**
         * Gets the radius of the circle
         *
         * @return the radius
         */
        public double getRadius() {
            return radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * Math.PI * radius;
        }

        @Override
        public boolean isValid() {
            return radius > 0;
        }

        @Override
        public String toString() {
            return String.format("Circle[radius=%.2f, area=%.2f]",
                               radius, calculateArea());
        }
    }
}
