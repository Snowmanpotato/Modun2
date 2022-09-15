import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số A!");
        double numA = input.nextDouble();

        System.out.println("Nhập số B!");
        double numB = input.nextDouble();

        System.out.println("Nhập số C!");
        double numC = input.nextDouble();

        QuadraticEquation count = new QuadraticEquation(numA,numB,numC);


        if(count.getDiscriminant()>0){
            System.out.printf("Với A = %s, B = %s, C = %s thì ta có delta = %s\n " +
                    "Phương trình cho ra hai nghiệm phân biệt là \n x1 = %s và x2 = %s",count.getNumberA(),count.getNumberB(),
                    count.getNumberC(),count.getDiscriminant(),count.getRoot1(),count.getRoot2());
        } else if (count.getDiscriminant()==0) {
            System.out.printf("Với A = %s, B = %s, C = %s thì ta có delta = %s\n " +
                            "Phương trình cho ra nghiệm chung là \n x1 =  x2 = %s",count.getNumberA(),count.getNumberB(),
                    count.getNumberC(),count.getDiscriminant(),count.getRoot1());
        }else {
            System.out.println("Phương trình vô nghiệm");
        }
    }
}
