package View;

import Form.User;
import Menu.Menu;
import Sever.UserSever;
import utils.Valid;

import java.time.LocalDateTime;
import java.util.Scanner;

import static Menu.Menu.scanner;

public class UserView {
    private static final UserSever userService = new UserSever();

    public static void runUser() {
        do {
            Scanner scanner = new Scanner(System.in);
            UserView managerUserView = new UserView();
            Menu.menuUser();
            try {
                System.out.println("\nChọn chức năng");
                System.out.print(" ⭆ ");
                int number = Integer.parseInt(scanner.nextLine());
                switch (number) {
                    case 1:
                        managerUserView.addUser();
                        break;
                    case 2:
                        managerUserView.updateUser();
                        break;
                    case 3:
                        managerUserView.deleteUser();
                        break;
                    case 4:
                        managerUserView.showUser();
                        break;
                    case 5:
                        managerUserView.showCustomer();
                        break;
                    case 8:
                        Menu.mainMenu();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Chọn chức năng không hợp lệ! Vui lòng chọn lại!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Chọn chức năng không hợp lệ! Vui lòng chọn lại!");
            }
        } while (true);
    }

    public void showUser() {
        userService.showAllUsers();
    }
    public void showCustomer() {
        userService.showAllCustomer();
    }



    public void addUser() {
        System.out.println("* * * * * BẤM 0 ĐỂ QUAY VỀ MENU TRƯỚC * * * * *  ");
        System.out.println("Nhập tên đăng nhập (gồm 5-31 kí tự, bắt đầu là 1 kí tự chữ và không chứa kí tự đặc biệt): ");
        String username = scanner.nextLine();
        while (userService.checkUserNameExist(username) || !Valid.isValidUserName(username)) {
            backToPreviousMenu(username,"runUser");
            if (!Valid.isValidUserName(username)) {
                System.out.println("Tên đăng nhập không hợp lệ! Vui lòng nhập lại: ");
            } else {
                System.out.println("Tên đăng nhập đã tồn tại! Nhập tên khác: ");
            }
            username = scanner.nextLine();
        }

        System.out.println("Nhập mật khẩu (ít nhất 8 kí tự, không bao gồm kí tự đặc biệt): ");
        String password = scanner.nextLine();
        while (!Valid.isValidPassWord(password)) {
            backToPreviousMenu(password,"runUser");
            System.out.println("Mật khẩu không hợp lệ! Vui lòng nhập lại: ");
            password = scanner.nextLine();
        }
        System.out.println("Nhập tên (viết hoa kí tự đầu tiên của mỗi chữ): ");
        String name = scanner.nextLine();
        while (userService.checkNameExist(name) || !Valid.isValidName(name)) {
            backToPreviousMenu(name,"runUser");
            if (!Valid.isValidName(name)) {
                System.out.println("Tên không hợp lệ! Vui lòng nhập lại: ");
            } else {
                System.out.println("Tên đã tồn tại! Nhập tên khác: ");
            }
            name = scanner.nextLine();
        }

        System.out.println("Nhập số điện thoại (bắt đầu bằng số 0, gồm có 10-11 số): ");
        String phone = scanner.nextLine();
        while (!Valid.isValidPhone(phone) || userService.checkPhoneExist(phone)) {
            backToPreviousMenu(phone,"runUser");
            if(userService.checkPhoneExist(phone)) {
                System.out.println("Số điện đã tồn tại! Vui lòng nhập lại: ");
            }else{
                System.out.println("Số điện thoại không hợp lệ! Vui lòng nhập lại: ");
            }
            phone = scanner.nextLine();
        }

        System.out.println("Nhập email: ");
        String email = scanner.nextLine();
        while (!Valid.isValidEmail(email) || userService.checkEmailExist(email)) {
            backToPreviousMenu(email,"runUser");
            if(userService.checkEmailExist(email)) {
                System.out.println("Email đã tồn tại! Vui lòng nhập lại: ");
            }else {
                System.out.println("Email không hợp lệ! Vui lòng nhập lại: ");
            }
            email = scanner.nextLine();
        }
        System.out.println("Nhập địa chỉ (không được để trống thông tin này, VD: Hue): ");
        String address = scanner.nextLine();
        while (address.trim().length() == 0) {
            backToPreviousMenu(address,"runUser");
            System.out.println("Địa chỉ không được để trống! Vui lòng nhập lại địa chỉ khác: ");
            address = scanner.nextLine();
        }
        System.out.println("Ủy quyền Admin");
        System.out.println("    ‖ ‖ ‖ ⇒⇒⇒ Set User ⇐⇐⇐ ‖ ‖ ‖");
        System.out.println("    ‖     1. Admin              ‖");
        System.out.println("    ‖     2. Customer           ‖");
        System.out.println("    ‖‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‖");
        String setAdmin="";

        while (setAdmin.trim().length() == 0){
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    setAdmin = "Admin";
                    break;
                case "2":
                    setAdmin = "Customer";
                    break;
                default:
                    System.out.println("Hiện tại chỉ có thể chọn 1 hoặc 2.Vui lòng chọn lại ");
            }
        }
        User user = new User(username, password, name, phone, email, address, setAdmin);
        userService.addUser(user);
        userService.showAllUsers();
    }

    private void backToPreviousMenu(String str, String nameMenu) {
        if (str.equals("0")) {
            if (nameMenu.equals("runUser")) {
                runUser();
            }else if(nameMenu.equals("updateUser")){
                updateUser();
            }
        }
    }

    public void updateUser() {
        do {
            try {
                Menu.menuUpdateUser();
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        updateFullInfo();
                        break;
                    case 2:
                        updateInfo();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    case 8:
                        runUser();
                        break;
                    default:
                        System.out.println("Vui lòng chọn đúng chức năng!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Chức năng không đúng! Vui lòng chọn lại!");
            }
        } while (true);
    }

    private void updateInfo() {
        showUser();
        System.out.println("* * * * * BẤM 0 ĐỂ QUAY VỀ MENU TRƯỚC ĐÓ * * * * *");
        long id = 0;
        do {
            try {
                System.out.println("Nhập ID tài khoản muốn sửa (bấm 0 để quay lại menu trước đó): ");
                id = Long.parseLong(scanner.nextLine());
                while (!userService.exist(id)) {
                    if (id == 0) {
                        updateUser();
                    }
                    System.out.println("ID không tồn tại! Vui lòng nhập lại ID: ");
                    id = Long.parseLong(scanner.nextLine());
                }
            } catch (Exception e) {
                System.out.println("ID không hợp lệ!");
            }
        } while (!userService.exist(id));

        User user = userService.getUserById(id);
        selectEditInfoUser(user);
        showUser();
    }

    private void selectEditInfoUser(User user) {
        do {
            Menu.menuUpdateInfoUser();

            int choice = -1;
            do {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    while (choice < 0 || (choice > 5 && choice != 8)){
                        System.out.println("Vui lòng chọn đúng chức năng: ");
                        choice = Integer.parseInt(scanner.nextLine());
                    }
                } catch (Exception e) {
                    System.out.println("Chọn lựa chọn phù hợp!");
                }
            } while (choice < 0 || (choice > 5 && choice != 8));

            switch (choice) {
                case 1:
                    String password = checkPasswordUser(user,"selectEditInfoUser");
                    user.setPassword(password);
                    user.setUpdateDay(LocalDateTime.now());
                    userService.update();
                    break;
                case 2:
                    String name = checkNameUser(user,"selectEditInfoUser");
                    user.setName(name);
                    user.setUpdateDay(LocalDateTime.now());
                    userService.update();
                    break;
                case 3:
                    String phone = checkPhoneUser(user,"selectEditInfoUser");
                    user.setPhone(phone);
                    user.setUpdateDay(LocalDateTime.now());
                    userService.update();
                    break;
                case 4:
                    String email = checkEmailUser(user,"selectEditInfoUser");
                    user.setEmail(email);
                    user.setUpdateDay(LocalDateTime.now());
                    userService.update();
                    break;
                case 5:
                    String address = checkAddressUser(user,"selectEditInfoUser");
                    user.setAddress(address);
                    user.setUpdateDay(LocalDateTime.now());
                    userService.update();
                    break;
                case 8:
                    updateUser();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhập lại lựa chọn phù hợp!");
                    break;
            }
            System.out.println("Thông tin của bạn đã được thay đổi thành công!");
        }while (true);
    }

    private void updateFullInfo() {
        showUser();
        System.out.println("* * * * * * NHẤN 0 ĐỂ QUAY LẠI MENU GẦN NHẤT * * * * * * ");
        int id = 0;
        do {
            try {
                System.out.println("Nhập ID muốn sửa: ");
                id = Integer.parseInt(scanner.nextLine());
                while (!userService.exist(id)) {
                    if (id == 0) {
                        updateUser();
                    } else {
                        System.out.println("Không tồn tại người dùng có ID này! Vui lòng nhập lại ID khác: ");
                    }
                    id = Integer.parseInt(scanner.nextLine());
                }
            } catch (Exception e) {
                System.out.println("ID không hợp lệ!");
            }
        } while (!userService.exist(id));
        User user = userService.getUserById(id);
        String password = checkPasswordUser(user,"updateUser");
        String name = checkNameUser(user,"updateUser");
        String phone = checkPhoneUser(user,"updateUser");
        String email = checkEmailUser(user,"updateUser");
        String address = checkAddressUser(user,"updateUser");

        if(password.equals("0") || name.equals("0") || phone.equals("0") || email.equals("0") || address.equals("0")){
            System.out.println("Thông tin người dùng chưa được thay đổi!");
        }else {
            user.setPassword(password);
            user.setName(name);
            user.setPhone(phone);
            user.setEmail(email);
            user.setAddress(address);
            user.setUpdateDay(LocalDateTime.now());
            System.out.println("Thông tin người dùng đã được chỉnh sửa thành công!");
            showUser();
            userService.update();
        }
    }

    private String checkAddressUser(User user , String str) {
        System.out.println("Nhập địa chỉ (không được để trống thông tin này, VD: Hue): ");
        String address = scanner.nextLine();
        while (user.getAddress().equals(address) || address.length() == 0) {
            if(str.equals("updateUser")) {
                backToPreviousMenu(address, "updateUser");
            }else if(address.equals("0")) {
                selectEditInfoUser(user);
            }
            if (user.getAddress().equals(address)) {
                System.out.println("Địa chỉ trùng với địa chỉ ban đầu! Vui lòng nhập lại địa chỉ: ");
            } else {
                System.out.println("Địa chỉ không được để trống! Vui lòng nhập lại: ");
            }
            address = scanner.nextLine();
        }
        return address;
    }

    private String checkEmailUser(User user, String str) {
        System.out.println("Nhập email: ");
        String email = scanner.nextLine();
        while (userService.checkEmailExist(email)|| !Valid.isValidEmail(email)) {
            if(str.equals("updateUser")) {
                backToPreviousMenu(email,"updateUser");
            }else if(email.equals("0")) {
                selectEditInfoUser(user);
            }
            if (user.getEmail().equals(email)) {
                System.out.println("Email trùng với email ban đầu! Vui lòng nhập lại email: ");
            } else if(!Valid.isValidEmail(email)){
                System.out.println("Email không hơp lệ! Vui lòng nhập lại email :");
            }else {
                System.out.println("Email đã tồn tại. Vui lòng nhập lại: ");
            }
            email = scanner.nextLine();
        }
        return email;
    }

    private String checkPhoneUser(User user, String str) {
        System.out.println("Nhập số điện thoại (bắt đầu bằng số 0, 10-11 số): ");
        String phone = scanner.nextLine();
        while (!Valid.isValidPhone(phone)||userService.checkPhoneExist(phone)) {
            if(str.equals("updateUser")) {
                backToPreviousMenu(phone,"updateUser");
            }else if(phone.equals("0")){
                selectEditInfoUser(user);
            }
            if (user.getPhone().equals(phone)) {
                System.out.println("Số điện thoại trùng với số điện thoại ban đầu! Vui lòng nhập lại SĐT: ");
            } else if(!Valid.isValidPhone(phone)) {
                System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại");
            }else {
                System.out.println("Số điện thoại đã tồn tại. Vui lòng nhập lại");
            }
            phone = scanner.nextLine();
        }
        return phone;
    }

    private String checkNameUser(User user, String str) {
        System.out.println("Nhập tên mới (viết hoa kí tự đầu tiên của mỗi chữ): ");
        String name = scanner.nextLine();
        while (user.getName().equals(name) || !Valid.isValidName(name)) {
            if(str.equals("updateUser")) {
                backToPreviousMenu(name, "updateUser");
            }else if(name.equals("0")){
                selectEditInfoUser(user);
            }
            if (user.getName().equals(name)) {
                System.out.println("Tên trùng với tên ban đầu! Vui lòng nhập lại tên khác: ");
            } else {
                System.out.println("Tên viết hoa kí tự đầu tiên của mỗi chữ. Vui lòng nhập lại tên khác: ");
            }
            name = scanner.nextLine();
        }
        return name;
    }

    private String checkPasswordUser(User user , String str) {
        System.out.println("Nhập mật khẩu mới (ít nhất 8 kí tự, không bao gồm kí tự đặc biệt): ");
        String password = scanner.nextLine();
        while (user.getPassword().equals(password) || !Valid.isValidPassWord(password)) {
            if(str.equals("updateUser")) {
                backToPreviousMenu(password, "updateUser");
            }else if(password.equals("0")){
                selectEditInfoUser(user);
            }
            if (user.getPassword().equals(password)) {
                System.out.println("Mật khẩu trùng với mật khẩu ban đầu! Vui lòng nhập lại mật khẩu khác: ");
            } else {
                System.out.println("Mật khẩu phải ít nhất 8 kí tự, không bao gồm kí tự đặc biệt! Vui lòng nhập mật khẩu khác: ");
            }
            password = scanner.nextLine();
        }
        return password;
    }

    public void deleteUser() {
        try {
            showUser();
            System.out.println("* * * * * BẤM 0 ĐỂ QUAY LẠI MENU TRƯỚC ĐÓ * * * * * ");
            System.out.println("Nhập ID muốn xóa: ");
            long id = Long.parseLong(scanner.nextLine());
            while (!userService.exist(id)) {
                backToPreviousMenu(Long.toString(id),"runUser");
                System.out.println("ID không tồn tại! Vui lòng nhập lại: ");
                id = Long.parseLong(scanner.nextLine());
            }
            userService.deleteUserByID(id);
            System.out.println("Người dùng có ID là " + id + " đã được xóa!\n");
            showUser();
        } catch (Exception e) {
            System.out.println("Vui lòng nhập ID hợp lệ!");
            deleteUser();
        }
    }

}

