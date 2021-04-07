package com.company;

public class Circle {
    private String name;
    private double radius;

    @Override
    public String toString() {
        return  "{\nName: " + getName() + "\nRadius: " + getRadius() +
                "\nArea: " + calculateArea() + "\nPerimeter:  " + calculatePerimete() + "\n}";
    }

    public Circle(String name, double radius) {
        this.name = name;
        this.radius = radius;
    }

    public Circle() {
    }

    public double calculateArea() {
        return Math.PI * Math.pow(getRadius(), 2);
    }

    public double calculatePerimete() {
        return 2 * Math.PI * getRadius();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
