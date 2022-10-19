package Form;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Product {
    private long productId;
    private String productName;
    private long quantity;
    private double price;
    private LocalDateTime dateAdded;

    private LocalDateTime updateDayProduct;

    public Product(String productName, long quantity, double price) {
        this.productId = System.currentTimeMillis()/1000;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.dateAdded = LocalDateTime.now();
        this.updateDayProduct = null;
    }

    public Product(String product){
        String[] strings = product.split(",");
        this.productId = Long.parseLong(strings[0].trim());
        this.productName = strings[1].trim();
        this.quantity = Long.parseLong(strings[2].trim());
        this.price = Double.parseDouble(strings[3].trim());
       // this.dateAdded = LocalDateTime.parse(strings[4].trim());
      //  this.updateDayProduct = LocalDateTime.parse(strings[5].trim());
    }

    public long getProductId() {
        return productId;
    }

    public LocalDateTime getUpdateDayProduct() {
        return updateDayProduct;
    }

    public void setUpdateDayProduct(LocalDateTime updateDayProduct) {
        this.updateDayProduct = updateDayProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return productId == product.productId && quantity == product.quantity && Objects.equals(productName, product.productName) && Objects.equals(dateAdded, product.dateAdded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, quantity, dateAdded);
    }

    @Override
    public String toString() {
        return productId+","+productName+","+quantity+","+price+","+dateAdded;
    }
}
