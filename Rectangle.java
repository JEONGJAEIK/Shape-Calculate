package section6;

public class Rectangle extends Shape{
    public int width;
    public int height;

    public Rectangle(int w, int h) {
        super("Rectangle");
        width = w;
        height = h;
    }

    public double computerArea() {
        return (double) width * height;
    }

    public double computerPerimeter() {
        return 2.0 * (width + height);
    }

    public String toString() {
        return "Rectangle: width is " + width + ", height is " + height;
    }
}
