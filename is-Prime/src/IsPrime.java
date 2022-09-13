import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số");
        int num = sc.nextInt();
        if (num < 2) {
            System.out.println(num + " không phải là số nguyên tố");
        } else {
            boolean check = true;
            int i = 2;
            while (i < Math.sqrt(num)) {
                if (num % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check) {
                System.out.println(num + " là số nguyên tố");
            } else {
                System.out.println(num + " không phải là số nguyên tố");
            }
        }
    }
}
