import java.util.Scanner;

public class SNTnhohon100 {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Bạn muốn hiển thị bao nhiêu số nguyên tố?");
        int num = 100;
        System.out.println("Hiển thị những số nguyên tố bé hơn 100");
        int N = 2;
        while (N<=num){

            if(isPrime(N)){
                System.out.printf("%d ",N);
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
