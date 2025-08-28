package oop;

/**
 * For every new shape we created, that extends the abstract shape class,
 * it will always have a toString method which calculates the area.
 * Unless we override toString again in that new shape we create
 */

public class Circle extends Shape {
    private int radius;

    public Circle(int radius){
        this.radius = radius;
    }
    @Override
    public int calculateArea() {
        return (int) (Math.PI * radius * radius);
    }
}

