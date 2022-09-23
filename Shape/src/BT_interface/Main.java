package BT_interface;

import Hinh_Hoc.Circle;
import Hinh_Hoc.Rectangle;
import Hinh_Hoc.Square;

public class Main {
    public static void main(String[] args) {
        Resizeable tron = new Circle(5);
        System.out.println("Before resize\n" + tron);
        tron.resize(50);
        System.out.println("After resize\n" + tron);


        Resizeable chuNhat = new Rectangle(5,10);
        System.out.println("Before resize\n" + chuNhat);
        chuNhat.resize(50);
        System.out.println("After resize\n" + chuNhat);


        Resizeable hinhVuong = new Square(6);
        System.out.println("Before resize\n" + hinhVuong);
        hinhVuong.resize(50);
        System.out.println("After resize\n" + hinhVuong);


    }
}
