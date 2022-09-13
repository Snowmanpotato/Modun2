import java.util.Scanner;

public class UCLN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Nhập số A");
        int numA = input.nextInt();

        System.out.println("Nhập số B");
        int numB = input.nextInt();

        numA = Math.abs(numA);
        numB = Math.abs(numB);

        if (numA == 0 || numB == 0) {
            System.out.println("Không có ước chung lớn nhất!");
        }
        while (numA != numB) {
            if (numA > numB) {
                numA = numA - numB;
            } else {
                numB = numB - numA;
            }
        }
        System.out.println("Ước chung lớn nhất của " + numA + " và "+numB+" là " + numA);
    }
}
