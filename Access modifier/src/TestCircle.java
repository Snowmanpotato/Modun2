public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(2);
        System.out.println(c1.getColor());
        System.out.println(c1.getRadius());

        System.out.println(c2.getColor());
        System.out.println(c2.getRadius());
    }
}
