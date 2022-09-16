public class TestStaticMethod {
    public static void main(String[] args) {
        Students.change();

        Students s1 = new Students(1, "Loi");
        Students s2 = new Students(2, "Duy");
        Students s3 = new Students(3, "Cuong");

        s1.display();
        s2.display();
        s3.display();
    }
}
