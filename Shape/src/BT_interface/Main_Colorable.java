package BT_interface;

import Hinh_Hoc.Circle;
import Hinh_Hoc.Rectangle;
import Hinh_Hoc.Square;

public class Main_Colorable {
    public static void main(String[] args) {
        Colorable[] shapes = new Colorable[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(5, 6);
        shapes[2] = new Square(10);


        for (Colorable item : shapes
        ) {
            System.out.println(item.getArea());
            if (item instanceof Colorable) {
                item.howToColor();
            }

        }
    }
}
