import java.util.Scanner;

public class findMax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        int[] array;
        do {
            System.out.println("Nhập kích thước mảng!");
            size = input.nextInt();
            if (size > 20) {
                System.out.println("Vui lòng nhập kích thước mảng bé hơn 20");
            }
        } while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.println("Nhập phần tử " + (i + 1) + " của mảng");
            array[i] = input.nextInt();
            i++;
        }

        System.out.print("Danh sách mảng: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }

        int max = array[0];
        int index = 0;
        for (int j = 0; j< array.length;j++){
            if(array[j]>max){
                max= array[j];
                index= j +1;
            }
        }
        System.out.println("Giá trị lớn nhất trong mảng là " + max+ " tại vị trí " + index);
    }
}
