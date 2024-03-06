package section6;

import java.util.Arrays;
import java.util.Scanner;

public class ShapeApplication{

    private int capacity = 10;
    private Shape[] shapes = new Shape [capacity];
    private int n = 0;
    private Scanner  kb = new Scanner(System.in);

    public void processCommand() {
        label:
        while(true) {
            System.out.print("$ ");
            String command = kb.next();
            switch (command) {
                case "add":
                    handleAdd();
                    break;
                case "show":
                case "showdetail":
                    handleShow(command.equals("showdetail"));
                    break;
                case "sort":
                    Arrays.sort(shapes, 0, n);
                    break;
                case "exit":
                    break label;
            }
        }
        kb.close();
    }

    private void handleShow(boolean detailed) {
        for (int i = 0; i < n; i++){
            System.out.println((i+1) + ". " + shapes[i].toString());
            if(detailed) {
                System.out.println("    The area is " + shapes[i].computerArea());
                System.out.println("    The perimeter is " + shapes[i].computerPerimeter());
            }
        }
    }

    private void handleAdd() {
        String type = kb.next();
        switch (type) {
            case "R": {
                addShape(new Rectangle(kb.nextInt(),kb.nextInt()));
                break;
            }
            case "C": {
                addShape(new Circle(kb.nextInt()));
                break;
            }
        }
    }

    private void addShape(Shape shape) {
        if (n >= capacity) {
            reallocate();
        }
        shapes[n++] = shape;
    }

    private void reallocate() {
        capacity *= 2;
        Shape[] tmp = new Shape[capacity];
        System.arraycopy(shapes,0,tmp,0,shapes.length);
        shapes = tmp;
    }

    public static void main(String[] args) {
        ShapeApplication app = new ShapeApplication();
        app.processCommand();

    }
}
