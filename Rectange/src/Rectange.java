public class Rectange {
    double height, width;

    public  Rectange(double width , double height) {
        this.height =height;
        this.width = width;
    }
    public double getArea(){
        return (this.height*this.width);
    }
    public  double getPerimeter(){
            return (this.height + this.width)*2;
    }
    public String display(){
        return "Rectangle{" + "width= " + width+ ", height= "+ height+ "}";
    }
}
