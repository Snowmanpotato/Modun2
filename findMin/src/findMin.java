

public class findMin {
    public static void main(String[] args) {
        int[] array = {4, 12, 7, 8, 1, 6, 9};
        int index = minValue(array);
        System.out.println("Giá trị nhỏ nhất trong mảng là: " + array[index]);
    }

    public static int minValue(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[index]) {
                index = i;
            }
        }
        return index;
    }
}
