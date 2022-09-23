package Hinh_Hoc;

import BT_interface.Colorable;
import BT_interface.Resizeable;

public class Square extends Rectangle implements Resizeable<Double>, Colorable<String> {
    public Square(){

    }
    public Square(double side){
        super(side,side);
    }
    public Square(double side, String color, boolean filled){
        super(side,side,color,filled);
    }


    public double getSide() {
        return getWidth();
    }
    public void setSide(double side) {
         setWidth(side);
         setLength(side);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
    }

    @Override
    public void resize(double percent) {
       super.setWidth((super.getWidth()/100)*percent);
        super.setLength((super.getLength()/100)*percent);
    }

    @Override
    public String toString() {
        return "A Hinh_Hoc.Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }
}
