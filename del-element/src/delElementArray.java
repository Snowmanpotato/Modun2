import java.util.Scanner;

public class delElementArray {
    public static void main(String[] args) {
        int[] array = {10,4,6,7,8,6,0,0,0,0};
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập phần tử cần xóa: ");
        int numDel = input.nextInt();
        int indexDel=0;
        for (int i = 0;i<array.length;i++){
            if(numDel == array[i]){
                indexDel = i;
            }else {
                System.out.println("Phần tử cần xóa không nằm trong mảng!");
            }
        }
        int i = indexDel;
        while (i< array.length-1){
            array[i] = array[i+1];
            i++;
        }
        for (int j = 0; j< array.length;j++){
            System.out.print(array[j]+" \t");
        }

    }
//    public static int positionDel(int[] arr,int num){
//
//        return indexDel;
//    }
}
