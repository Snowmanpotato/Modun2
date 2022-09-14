import java.util.Scanner;

public class ShowSNT {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Bạn muốn hiển thị bao nhiêu số nguyên tố?");
        int num = input.nextInt();
        System.out.printf("%d số nguyên tố đầu tiên là \n",num);
        int count = 0;
        int N = 2;
        while (count<=num){
            if(isPrime(N)){
                System.out.printf("%d ",N);
                count++;
            }
            N++;
        }


    }

    public static boolean isPrime(int n) {
        if(n<2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
