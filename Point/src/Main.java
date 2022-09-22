public class Main {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);

        point = new Point(2.3f,3.3f);
        System.out.println(point);

        MoveablePoint moveablePoint = new MoveablePoint();
        System.out.println(moveablePoint);

        moveablePoint = new MoveablePoint(5.5f,6.6f);
        System.out.println(moveablePoint);

        moveablePoint = new MoveablePoint(1.1f,2.2f,6.1f,3.9f);
        System.out.println(moveablePoint);
    }
}
