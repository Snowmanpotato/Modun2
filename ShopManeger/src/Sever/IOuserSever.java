package Sever;

import Form.User;

import java.util.ArrayList;

public interface IOuserSever {
    ArrayList<User> getUsers();

    User loginAdmin(String username, String password);

    void addUser(User newUser);
    void deleteUserByID(long id);

    boolean exist(long id);

    boolean checkEmailExist(String email);

    boolean checkPhoneExist(String phone);

    boolean checkUserNameExist(String userName);

    User getUserById(long id);

    User getUserByUserName(String userName);
    User getUserByName(String name);

    void update();
}
