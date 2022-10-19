package Sever;


import Form.OrderItem;
import Form.Product;
import Form.User;
import Menu.Menu;
import View.OrderView;
import utils.ReadAndWrite;
import utils.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderItemService implements IOrderItemServices{
    public static ArrayList<OrderItem> listOrderItem = new ArrayList<>();

    public static ArrayList<OrderItem> listOrderPaid = new ArrayList<>();
    private static final UserSever userServices = new UserSever();
    private static final OrderView orderView = new OrderView();
    private static final String fileName = "C:\\Users\\Admin\\Desktop\\orderItem.txt";
    private static final String path = "C:\\Users\\Admin\\Desktop\\orderPaid.txt";



    @Override
    public List<OrderItem> getOrderItems() {
        if (listOrderItem.size() == 0) {
            List<String> orderItems = ReadAndWrite.readFile(fileName);

            for (String orderItem : orderItems) {
                listOrderItem.add(new OrderItem(orderItem));
            }
            return listOrderItem;
        }
        return null;
    }

    public static List<OrderItem> getOrdersPaid() {
        if (listOrderPaid.size() == 0) {
            List<String> records = ReadAndWrite.readFile(path);

            for (String record : records) {
                listOrderPaid.add(new OrderItem(record));
            }
            return listOrderPaid;
        }
        return null;
    }

    public static void addOrderPaid(OrderItem newOrder) {
        listOrderPaid.add(newOrder);
        updateOrderListPaid();
    }

    public static void updateOrderListPaid() {
        ReadAndWrite.writeFile(path, listOrderPaid);
    }

    @Override
    public void add(OrderItem newOrderItem) {
        listOrderItem.add(newOrderItem);
        ReadAndWrite.writeFile(fileName, listOrderItem);
    }

    @Override
    public void update() {
        ReadAndWrite.writeFile(fileName, listOrderItem);
    }

    @Override
    public OrderItem getOrderItemById(long id) {
        for (OrderItem orderItem : listOrderItem) {
            if (orderItem.getOrderId() == id) {
                return orderItem;
            }
        }
        return null;
    }

    public OrderItem getOrderItemByName(String name) {
        for (OrderItem orderItem : listOrderItem) {
            if (Objects.equals(orderItem.getName(), name)) {
                return orderItem;
            }
        }
        return null;
    }

    public List<OrderItem> getListOrderItemByName(String name) {
        List<OrderItem> list = new ArrayList<>();
        for (OrderItem orderItem : listOrderItem) {
            if (Objects.equals(orderItem.getName(), name)) {
                list.add(orderItem);
            }
        }
        return list;
    }

    public boolean isExistProduct(Product product) {
        for (OrderItem orderItem : listOrderItem) {
            if (orderItem.getProductId() == product.getProductId()) {
                return true;
            }
        }
        return false;
    }

    public void resetListOrderItem(String name) {
        listOrderItem.removeIf(orderItem -> (orderItem.getName().equals(name)));
        ReadAndWrite.writeFile(fileName, listOrderItem);
    }

    public static boolean isExistNameOfOrderItemList(String name) {
        for(OrderItem orderItem : listOrderItem){
            if(orderItem.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkNameOnList(String name) {
        for (OrderItem orderItem : listOrderItem) {
            if (orderItem.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void showListOrder() {
        User user = userServices.getUserById(Menu.userId);
        if (!checkNameOnList(user.getName())) {
            System.out.println("----------  Danh sách sản phẩm đặt hàng trống!  ----------");
            System.out.println(" ");
        }
        double totalMoney = 0;
        System.out.println("------------------------------------------------- DANH SÁCH ĐẶT HÀNG CỦA BẠN -------------------------------------------------");
        System.out.printf("*             %-15s %-18s %-12s %-15s %-20s %-16s *\n", "ID", "Tên sản phẩm", "Giá", "Số lượng", "Tổng tiền", "Thời gian mua");

        for (OrderItem orderItem : listOrderItem) {
            if (user.getName().equals(orderItem.getName())) {
                totalMoney += orderItem.getTotal();
                System.out.printf("*        %-16s %-20s %-15s  %-13s %-20s %-16s *\n", orderItem.getId(),
                        orderItem.getProductName(), Valid.priceToString(orderItem.getPrice()),
                        orderItem.getQuantity(), Valid.priceToString(orderItem.getTotal()),
                        orderItem.getDate());
            }
        }
        System.out.println("-----------------------------------------------------------------------------------  TỔNG TIỀN: " + Valid.priceToString(totalMoney) + "  --------------------");
        orderView.showBill(totalMoney);
    }
}

