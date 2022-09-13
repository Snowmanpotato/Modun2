import java.util.Scanner;

public class interestCaculation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Nhập số tiền gửi!");
        double monney = input.nextDouble();

        System.out.println("Nhập lãi suất ngân hàng!");
        double interrest = input.nextDouble();

        System.out.println("Nhập số tháng gửi!");
        int month = input.nextInt();

        double total =0;
        for (int i =0; i<month;i++){
            total += monney * (interrest/100)/12 * month;
        }
        System.out.printf("Tiền lãi là: %.3f", total);
    }
}
