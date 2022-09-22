public class Cylinder extends Circle{
    private double hight = 1.0;

    public Cylinder(){

    }
    public Cylinder(double hight){
        this.hight=hight;
    }
    public Cylinder(double hight, double radius, String color){
        super(radius, color);
        this.hight = hight;
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    @Override
    public void setRadius(double radius) {
        super.setRadius(radius);
    }

    public double getHight() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }
    @Override
    public String toString() {

        return "A Cylinder with radius= "
                + super.getRadius()
                + "A Cylinder with hight= "
                + getHight()
                + ", which is a subclass of "
                + super.getColor();
    }
}
