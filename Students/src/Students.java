public class Students {
    private int Num;
    private String Name;
    private static String School;

    Students(int number, String name) {
        Num = number;
        Name = name;
    }

    static void change() {
        School = "CODEGYM";
    }

    void display() {
        System.out.println(Num + " " + Name + " " + School);
    }
}
