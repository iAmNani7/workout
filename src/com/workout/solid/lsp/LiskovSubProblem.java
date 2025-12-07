package com.workout.solid.lsp;

/**
 * Demonstration of Liskov Substitution Principle (LSP) Problem
 *
 * This class demonstrates a violation of LSP where a subclass cannot be
 * substituted for its parent class without breaking the functionality.
 *
 * The LSP states that objects of a superclass should be replaceable with
 * objects of its subclasses without altering the correctness of the program.
 *
 * @author Workout Team
 * @version 1.0
 * @since 2025-12-07
 */
public class LiskovSubProblem {

    /**
     * Main method to demonstrate LSP violation
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== Liskov Substitution Principle - Problem Demonstration ===");

        // This demonstrates LSP violation
        demonstrateLspViolation();
    }

    /**
     * Demonstrates a violation of the Liskov Substitution Principle
     * where a subclass cannot properly substitute its parent class
     */
    private static void demonstrateLspViolation() {
        System.out.println("\n--- LSP Violation Example ---");

        // Using parent class reference
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(5);
        rectangle.setHeight(4);
        System.out.println("Rectangle area: " + rectangle.getArea());

        // Using subclass - this breaks LSP as Square behaves differently
        Rectangle square = new Square();
        square.setWidth(5);
        square.setHeight(4);
        System.out.println("Square area (should be 20 but isn't): " + square.getArea());

        // Demonstrating the problem with a method that expects Rectangle behavior
        testRectangleAssumption(new Rectangle());
        testRectangleAssumption(new Square()); // This breaks the assumption
    }

    /**
     * Tests assumptions about Rectangle behavior
     * This method expects that setting width and height independently works
     *
     * @param rectangle the rectangle to test
     */
    private static void testRectangleAssumption(Rectangle rectangle) {
        rectangle.setWidth(5);
        rectangle.setHeight(4);

        System.out.println("Testing " + rectangle.getClass().getSimpleName() + ":");
        System.out.println("Width: " + rectangle.getWidth() + ", Height: " + rectangle.getHeight());
        System.out.println("Expected area: 20, Actual area: " + rectangle.getArea());
        System.out.println("LSP satisfied: " + (rectangle.getArea() == 20));
        System.out.println();
    }

    /**
     * Rectangle class representing a basic rectangle shape
     */
    static class Rectangle {
        protected double width;
        protected double height;

        /**
         * Default constructor
         */
        public Rectangle() {
            this.width = 0.0;
            this.height = 0.0;
        }

        /**
         * Constructor with width and height
         *
         * @param width the width of the rectangle
         * @param height the height of the rectangle
         */
        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        /**
         * Sets the width of the rectangle
         *
         * @param width the width to set
         */
        public void setWidth(double width) {
            this.width = width;
        }

        /**
         * Sets the height of the rectangle
         *
         * @param height the height to set
         */
        public void setHeight(double height) {
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

        /**
         * Calculates and returns the area of the rectangle
         *
         * @return the area (width * height)
         */
        public double getArea() {
            return width * height;
        }

        @Override
        public String toString() {
            return String.format("Rectangle[width=%.2f, height=%.2f, area=%.2f]",
                               width, height, getArea());
        }
    }

    /**
     * Square class that extends Rectangle
     * This implementation violates LSP because it changes the behavior
     * of the parent class methods in an unexpected way
     */
    static class Square extends Rectangle {

        /**
         * Default constructor
         */
        public Square() {
            super();
        }

        /**
         * Constructor with side length
         *
         * @param side the side length of the square
         */
        public Square(double side) {
            super(side, side);
        }

        /**
         * Sets the width and also sets height to maintain square property
         * This violates LSP as it changes expected behavior
         *
         * @param width the width to set (also sets height)
         */
        @Override
        public void setWidth(double width) {
            this.width = width;
            this.height = width; // LSP violation: unexpected side effect
        }

        /**
         * Sets the height and also sets width to maintain square property
         * This violates LSP as it changes expected behavior
         *
         * @param height the height to set (also sets width)
         */
        @Override
        public void setHeight(double height) {
            this.width = height; // LSP violation: unexpected side effect
            this.height = height;
        }

        /**
         * Sets both width and height to the same value
         *
         * @param side the side length for the square
         */
        public void setSide(double side) {
            this.width = side;
            this.height = side;
        }

        /**
         * Gets the side length of the square
         *
         * @return the side length
         */
        public double getSide() {
            return width; // Assumes width and height are always equal
        }

        @Override
        public String toString() {
            return String.format("Square[side=%.2f, area=%.2f]",
                               width, getArea());
        }
    }
}
