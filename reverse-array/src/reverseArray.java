import java.util.Scanner;

public class reverseArray {
    public static void main(String[] args) {
        int size;
        int [] array;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Nhập kích thước mảng");
            size = input.nextInt();
            if(size>20){
                System.out.println("Vui lòng nhập kích thước của mảng bé hơn 20");
            }

        }while (size>20);
        array = new int[size];
        int i =0;
        while (i<array.length){
            System.out.println("nhập giá trị của phần tử "+(i+1)+" là: ");
            array[i] = input.nextInt();
            i++;
        }

        System.out.printf("%-20s%s", "Mảng: ", "");
        for (int j= 0; j< array.length;j++){
            System.out.print(array[j] + "\t");
        }

        for (int j = 0; j < array.length/2;j++){
            int temp = array[j];
            array[j] = array[array.length-1-j];
            array[array.length-1-j] = temp;
        }

        System.out.printf("\n%-20s%s", "Mảng đảo ngược: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}
