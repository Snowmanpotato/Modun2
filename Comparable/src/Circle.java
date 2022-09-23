public class Circle{
    private double radius = 1.0;
    private String color = "red";

    private boolean filler = false;

    public Circle(){

    }
    public Circle(double radius){
        this.radius= radius;
    }
    public Circle(double radius, String color){
        this.radius= radius;
        this.color = color;
    }

    public Circle(double radius, String color, boolean filler){
        this.radius= radius;
        this.color = color;
        this.filler = filler;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return radius*radius*Math.PI;
    }
    public double getPerimeter(){
        return 2*radius*Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                + ", which is a subclass of "
                + getColor();
    }
}