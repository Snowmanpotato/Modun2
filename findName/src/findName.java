import java.util.Scanner;

public class findName {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya",
                "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên bạn cần tìm");
        String inputName = input.nextLine();

        boolean isFound = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equalsIgnoreCase(inputName)) {
                System.out.println("Vị trí tìm thấy tên " + inputName + " trong danh sách là: " + i);
                isFound = true;
                break;
            }
        }
        if(!isFound){
            System.out.println("Không tìm thấy "+inputName+" trong danh sách!");
        }
    }
}
