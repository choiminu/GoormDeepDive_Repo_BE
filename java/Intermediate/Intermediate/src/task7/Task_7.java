package task7;

public class Task_7 {
    public static void main(String[] args) {
        ShapeInterface[] shapeInterfaces = new ShapeInterface[3];

        shapeInterfaces[0] = new Circle(5.0);
        shapeInterfaces[1] = new Rectangle(4.0, 6.0);
        shapeInterfaces[2] = new Triangle(4.0, 3.0);

        for (ShapeInterface shapeInterface : shapeInterfaces) {
            System.out.println("Shape Area = " + shapeInterface.getArea());
        }
    }
}


interface ShapeInterface {
    double getArea();
}

abstract class AbstractShape implements ShapeInterface {

}

class Circle extends AbstractShape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends AbstractShape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

class Triangle extends AbstractShape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}