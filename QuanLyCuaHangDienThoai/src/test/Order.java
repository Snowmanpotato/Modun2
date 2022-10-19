import java.util.ArrayList;

import java.util.Objects;

public class Order {
    private int idOrder;
    private Custumer custumer;
    private ArrayList<ProductPhone> listProductPhone;

    public Order() {
    }

    public Order(int idOrder, Custumer custumer, ArrayList<ProductPhone> listProductPhone) {
        this.idOrder = idOrder;
        this.custumer = custumer;
        this.listProductPhone = listProductPhone;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Custumer getCustumer() {
        return custumer;
    }

    public void setCustumer(Custumer custumer) {
        this.custumer = custumer;
    }

    public ArrayList<ProductPhone> getListProductPhone() {
        return listProductPhone;
    }

    public void setListProductPhone(ArrayList<ProductPhone> listProductPhone) {
        this.listProductPhone = listProductPhone;
    }

    //Hàm tính tổng tiền Order
    public double getTotalOrder() {
        double totalOrder = 0;
        for (int i = 0; i < listProductPhone.size(); i++) {
            double totalProduct = listProductPhone.get(i).getPriceProduct() * listProductPhone.get(i).getAmountProduct();
            totalOrder += totalProduct;
        }
        return totalOrder;
    }

    //Xóa sản phẩm khỏi danh sách theo Id
    public void deleteProductById(int id) {
        for (int i = 0; i < listProductPhone.size(); i++) {
            if (listProductPhone.get(i).getIdProduct() == id) {
                listProductPhone.remove(i);
            }
        }
    }

    //Sửa tên sản phẩm theo id
    public void renameProductById(int id, String changeName) {
        for (int i = 0; i < listProductPhone.size(); i++) {
            if (listProductPhone.get(i).getIdProduct() == id) {
                listProductPhone.get(i).setNameProduct(changeName);
            }
        }
    }

    //Tìm sản phẩm theo tên sản phẩm
    public ArrayList<ProductPhone> findProductByProductName(String nameProduct) {
        ArrayList<ProductPhone> listProductFind = new ArrayList<>();
        for (int i = 0; i < listProductPhone.size(); i++) {
            if (((listProductPhone.get(i).getNameProduct()).toLowerCase()).contains(nameProduct.toLowerCase())) {
                listProductFind.add(listProductPhone.get(i));
            }
        }
        return listProductFind;
    }

    //Tìm sản phẩm theo tên sản phẩm và mô tả
    public ArrayList<ProductPhone> findProductByNameAndDescription(String nameProduct, String description) {
        ArrayList<ProductPhone> listProductFind = new ArrayList<>();
        for (int i = 0; i < listProductPhone.size(); i++) {
            if (listProductPhone.get(i).getNameProduct().equalsIgnoreCase(nameProduct) &&
                    listProductPhone.get(i).getSortDescription().equalsIgnoreCase(description)) {
                listProductFind.add(listProductPhone.get(i));
            }
        }
        return listProductFind;
    }

    // Câu 6: Sắp xếp sản phẩm theo thứ tự từ a-z, giá tiền, số lượng
    public void sortProduct() {
        for (int i = 0; i < listProductPhone.size(); i++) {
            ProductPhone min = listProductPhone.get(i);
            int index = i;
            for (int j = i + 1; j < listProductPhone.size(); j++) {
                if (min.compareTo(listProductPhone.get(j)) > 0) {
                    min = listProductPhone.get(j);
                    index = j;
                }
            }
            listProductPhone.set(index,listProductPhone.get(i));
            listProductPhone.set(i,min);

        }

    }
    // Câu 7:In ra hóa đơn theo định dạng


    @Override
    public String toString() {
        return "Order {" +
                "idOrder=" + idOrder +
                ", custumer=" + custumer +
                ", listProductPhone=" + listProductPhone +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return idOrder == order.idOrder && Objects.equals(custumer, order.custumer) && Objects.equals(listProductPhone, order.listProductPhone);
    }

    //    @Override
//    public int hashCode() {
//        return Objects.hash(idOrder, custumer, listProductPhone);
//    }
    @Override
    public int hashCode() {
        return Objects.hash(idOrder);
    }
}
