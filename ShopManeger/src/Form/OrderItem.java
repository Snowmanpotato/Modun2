package Form;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderItem{
    private long id;
    private String name;
    private double price;
    private int quantity;
    private long orderId;
    private long productId;
    private String productName;
    private double total;
    private LocalDateTime date;

    public OrderItem(long id,String name, double price, int quantity, long orderId, long productId, String productName, double total) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.total = total;
        this.date = LocalDateTime.now();
    }

    public OrderItem(){
    }
    public OrderItem(String record) {
        String[] strings = record.split(",");
        id = Long.parseLong(strings[0].trim());
        name = strings[1].trim();
        price = Double.parseDouble(strings[2].trim());
        quantity = Integer.parseInt(strings[3].trim());
        orderId = Long.parseLong(strings[4].trim());
        productId = Long.parseLong(strings[5].trim());
        productName = strings[6].trim();
        total = Double.parseDouble(strings[7].trim());
        date = LocalDateTime.parse(strings[8].trim());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + price + "," + quantity + "," + orderId + ","
                + productId + "," + productName + "," + total + "," + date;
    }
}

