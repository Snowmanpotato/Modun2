import java.util.Scanner;

public class BMIcaculation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter weight (in kilogram)?");
        double weight = input.nextDouble();

        System.out.println("Enter height (in meter)?");
        double height = input.nextDouble();

        double bmi = weight / Math.pow(height, 2);
        System.out.printf("%-20s%s", "bmi", "Interpretation\n");

        if(bmi<18){
            System.out.printf("%-20.2f%s", bmi , "Underweight");
        } else if (bmi<25.0) {
            System.out.printf("%-20.2f%s", bmi , "Normal");
        } else if (bmi<30.0) {
            System.out.printf("%-20.2f%s", bmi , "Overweight");
        } else {
            System.out.printf("%-20.2f%s", bmi , "Obese");
        }
    }
}
