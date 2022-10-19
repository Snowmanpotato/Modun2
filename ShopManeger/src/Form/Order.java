package Form;


import java.time.LocalDateTime;
import java.time.LocalTime;

public class Order  {
    private long id;
    private String name;
    private String phone;
    private String address;

    public Order(long id, String name, String phone, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
    public Order (String order){
        String[] strings = order.split(",");
        id = Long.parseLong(strings[0].trim());
        name = strings[1].trim();
        phone = strings[2].trim();
        address = strings[3].trim();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return id+","+name+","+phone+","+address;
    }
}
