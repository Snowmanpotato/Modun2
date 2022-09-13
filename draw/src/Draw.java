import java.util.Scanner;

public class Draw {
    public static void main(String[] args) {
int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0){
            System.out.println("Menu");
            System.out.println("1. Hình chữ nhật");
            System.out.println("2. Tam giác trên");
            System.out.println("3. Tam giác dưới");
            System.out.println("0. Thoát");
            System.out.println("Đưa ra lựa chọn");
            choice = input.nextInt();
            switch (choice){
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("1. Hình chữ nhật");
                    ChuNhat();
                    break;
                case 2:
                    System.out.println("2. Tam giác trên");
                    tamGiacDuoi();
                    break;
                case 3:
                    System.out.println("3. Tam giác dưới");
                    tamGiacTren();
                    break;
                default:
                    System.out.println("Chọn lại đi");
            }
        }
    }
    public static void ChuNhat() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print("* ");
            }
            System.out.println("\n");
        }
    }
    public static void tamGiacDuoi(){
        for (int i = 0; i< 5;i++){
            for (int j = 0; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println("\n");
        }
    }
    public static void tamGiacTren(){
        for (int i = 0; i< 5;i++){
            for (int j = 5; j>i; j--){
                System.out.print("* ");
            }
            System.out.println("\n");
        }
    }
}
