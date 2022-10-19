package Sever;

import Form.Order;
import Form.OrderItem;
import utils.ReadAndWrite;
import utils.Valid;

import java.util.ArrayList;
import java.util.List;

public class OrderService implements IOrderService{
    public static ArrayList<Order> listOder = new ArrayList<>();

    private final String fileName = "C:\\Users\\Admin\\Desktop\\order.txt";
    @Override
    public List<Order> getOrders() {
        if (listOder.size() == 0) {
            List<String> lists = ReadAndWrite.readFile(fileName);
            for (String order : lists
            ) {
                listOder.add(new Order(order));
            }
            return listOder;
    }
        return null;
    }
    @Override
    public void add(Order newOrder) {
        listOder.add(newOrder);
        update();
    }

    @Override
    public void update() {
        ReadAndWrite.writeFile(fileName, listOder);
    }

    @Override
    public Order getOrderById(int id) {
        for (Order order : listOder
        ) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    @Override
    public boolean exist(int id) {
        for (Order order : listOder
        ) {
            if (order.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkDuplicateName(String name) { //check trung ten
        for (Order order : listOder) {
            if (order.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkDuplicateId(int id) {
        for (Order order : listOder) {
            if (order.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(Order order) {
        listOder.remove(order);
        update();
    }
    public static boolean checkExistNameOfOrder(String name) {
        for (Order order : listOder) {
            if (order.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public static void showListOrder() {
        if (listOder.size()==0) {
            System.out.println("----------Danh sách sản phẩm đặt hàng trống!----------");
            System.out.println(" ");
        } else {
            System.out.println("--------------------------------------------------------------  LỊCH SỬ ĐẶT HÀNG  --------------------------------------------------------------");
            for (Order order : listOder) {
                double totalMoney = 0;
                System.out.printf("*   %-25s %-1s %-15s %-1s %-15s %-1s %-15s %-1s %-30s  * \n", "Thông tin người dùng", "ID:"
                        , order.getId(), "Tên:", order.getName(),
                        "Số điện thoại:", order.getPhone(), "Địa chỉ:", order.getAddress());
                System.out.printf("*%-142s*\n", "");
                System.out.printf("*            %-12s %-22s %-12s %-17s %-20s %-41s *\n", "ID",
                        "Tên sản phẩm", "Giá", "Số lượng", "Tổng tiền", "Thời gian đặt");
                for (OrderItem orderItem : OrderItemService.listOrderPaid) {
                    if (order.getName().equals(orderItem.getName())){
                        totalMoney += orderItem.getTotal();
                        System.out.printf("*       %-16s %-22s %-15s  %-13s %-20s %-42s *\n", orderItem.getId(), orderItem.getProductName(),
                                Valid.priceToString(orderItem.getPrice()), orderItem.getQuantity(),
                                Valid.priceToString(orderItem.getTotal()), orderItem.getDate());
                    }
                }
                System.out.println("---------------------------------------------------------------------------TỔNG TIỀN: "
                        + Valid.priceToString(totalMoney) + " ------------------------------------------------");
                System.out.println(" ");
            }
        }
    }
}
