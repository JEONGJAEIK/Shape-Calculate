package section6;

public abstract class Shape {

    public String shapeName;

    public Shape(String name) {
        shapeName = name;
    }

    public abstract double computerArea();
    public abstract double computerPerimeter();
}
