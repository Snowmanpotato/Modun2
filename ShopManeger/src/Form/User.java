package Form;


import utils.Valid;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

public class User {
    private long userId; //id người dùng
    private String userName; // tên tài khoản người dùng
    private String password; //mật khẩu người dùng
    private String name; // họ và tên người dùng
    private String phone; // SDT người dùng
    private String email;  // email
    private String address; //địa chỉ
    private String setUser; // đặt quyền người dùng là admin hoặc user
    private LocalDateTime registerDate; // ngày tạo

    private LocalDateTime updateDay; // ngày cập nhật

    public User(String userName, String password, String name, String phone, String email, String address, String setUser) {
        this.userId = System.currentTimeMillis() / 1000;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.setUser = setUser;
        this.registerDate = LocalDateTime.now();

    }

    public User(String userObj) {
        String[] strings = userObj.split(",");
        this.userId = Long.parseLong(strings[0].trim());
        this.userName = strings[1].trim();
        this.password = strings[2].trim();
        this.name = strings[3].trim();
        this.phone = strings[4].trim();
        this.email = strings[5].trim();
        this.address = strings[6].trim();
        this.setUser = strings[7].trim();
        this.registerDate = LocalDateTime.parse(strings[8].trim());
        if (!(this.updateDay ==null)) {
            this.updateDay = LocalDateTime.parse(strings[9].trim());
        }

    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSetUser() {
        return setUser;
    }

    public void setSetUser(String setUser) {
        this.setUser = setUser;
    }

    public LocalDateTime getUpdateDay() {
        return updateDay;
    }

    public void setUpdateDay(LocalDateTime updateDay) {
        this.updateDay = updateDay;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(userName, user.userName) && Objects.equals(password, user.password) && Objects.equals(name, user.name) && Objects.equals(phone, user.phone) && Objects.equals(email, user.email) && Objects.equals(address, user.address) && Objects.equals(setUser, user.setUser) && Objects.equals(registerDate, user.registerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, password, name, phone, email, address, setUser, registerDate);
    }

    @Override
    public String toString() {
        return userId + "," + userName + "," + password + "," + name + "," + phone + "," + email + "," + address + "," + setUser + "," + registerDate;
    }
}
