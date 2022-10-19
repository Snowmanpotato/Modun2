package Sever;

import Form.User;
import utils.ReadAndWrite;
import utils.Valid;

import java.util.ArrayList;
import java.util.List;

public class UserSever implements IOuserSever {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static String fileName = "C:\\Users\\Admin\\Desktop\\admin.txt";

    @Override
    public ArrayList<User> getUsers() {
        if (listUser.size() == 0) {
            List<String> lists = ReadAndWrite.readFile(fileName);
            for (String user : lists
            ) {
                listUser.add(new User(user));
            }
            return listUser;
        }
        return null;
    }

    @Override
    public User loginAdmin(String username, String password) {
        for (User user : listUser) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                if (user.getSetUser().trim().equals("Admin")) {
                    return user;
                }
            }
        }
        return null;
    }

    public User loginCustomer(String username, String password) {
        for (User user : listUser) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                if (user.getSetUser().trim().equals("Customer")) {
                    return user;
                }
            }
        }
        return null;
    }

    @Override
    public void addUser(User newUser) {
        listUser.add(newUser);
        update();
    }

    @Override
    public void deleteUserByID(long id) {
        listUser.remove(getUserById(id));
        update();
    }

    @Override
    public boolean exist(long id) {
        for (User user : listUser
        ) {
            if (user.getUserId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkEmailExist(String email) {
        for (User user : listUser
        ) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkPhoneExist(String phone) {
        for (User user : listUser
        ) {
            if (user.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkNameExist(String name) {
        for (User user : listUser
        ) {
            if (user.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkUserNameExist(String userName) {
        for (User user : listUser
        ) {
            if (user.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User getUserById(long id) {
        for (User user : listUser
        ) {
            if (user.getUserId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByUserName(String userName) {
        for (User user : listUser
        ) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByName(String name) {
        for (User user : listUser
        ) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void update() {
        ReadAndWrite.writeFile(fileName, listUser);
    }

    public void updateUserById(long id, User editUser) {
        getUserById(id).setName(editUser.getName());
        getUserById(id).setPhone(editUser.getPhone());
        getUserById(id).setEmail(editUser.getEmail());
        getUserById(id).setAddress(editUser.getAddress());
        update();
    }

    public void showAllUsers() {
        if (listUser.size() == 0) {
            System.out.println(" ");
            System.out.println("===============  Danh sách người dùng trống!  ===============");
            System.out.println(" ");
        } else {
            System.out.println("----------------------------------------------------  LIST CUSTOMER  -----------------------------------------------");

            System.out.printf("     %-10s %-15s %-15s %-15s %-23s %-24s %-15s %-10s %-20s %-20s\n", "ID", "Tên đăng nhập", "Mật khẩu", "Tên", "Số điện thoại", "Email", "Địa chỉ", "User", "Ngày khởi tạo", "Ngày cập nhật");
            for (User user : listUser) {
                System.out.printf("%-15s %-15s %-15s %-15s %-15s %-32s %-15s %-10s %-20s %-20s\n", user.getUserId(), user.getUserName(), user.getPassword(), user.getName(), user.getPhone(), user.getEmail(), user.getAddress(),
                        user.getSetUser(), Valid.localDateTimeToDateWithSlash(user.getRegisterDate()), Valid.localDateTimeToDateWithSlash(user.getUpdateDay()));
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------------");
            System.out.println(" ");
        }
    }

    public void showAllCustomer() {
        if (listUser.size() == 0) {
            System.out.println(" ");
            System.out.println("===============  Danh sách người dùng trống!  ===============");
            System.out.println(" ");
        } else {
            System.out.println("----------------------------------------------------  LIST CUSTOMER  -----------------------------------------------");

            System.out.printf("     %-10s %-15s %-15s %-15s %-23s %-24s %-15s %-10s %-32s %-32s\n", "ID", "Tên đăng nhập", "Mật khẩu", "Tên", "Số điện thoại", "Email", "Địa chỉ", "User", "Ngày khởi tạo", "Ngày cập nhật");
            for (User user : listUser) {
                if (user.getSetUser().equals("Customer")) {
                    System.out.printf("%-15s %-15s %-15s %-15s %-15s %-32s %-15s %-10s %-32s %-32s\n", user.getUserId(), user.getUserName(), user.getPassword(), user.getName(), user.getPhone(), user.getEmail(), user.getAddress(),
                            user.getSetUser(), Valid.localDateTimeToDateWithSlash(user.getRegisterDate()), Valid.localDateTimeToDateWithSlash(user.getUpdateDay()));
                }

            }
            System.out.println("--------------------------------------------------------------------------------------------------------------------");
            System.out.println(" ");
        }
    }
}
