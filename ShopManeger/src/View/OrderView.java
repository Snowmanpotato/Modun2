package View;

import Form.Order;
import Form.OrderItem;
import Form.Product;
import Form.User;
import Menu.Menu;
import Sever.OrderItemService;
import Sever.OrderService;
import Sever.ProductService;
import Sever.UserSever;
import utils.Valid;
import java.util.Scanner;

public class OrderView {
    private static final ProductView productView = new ProductView();
    private static final Scanner scanner = new Scanner(System.in);
    private static final ProductService productService = new ProductService();
    private static final OrderService orderService = new OrderService();
    private static final UserSever userService = new UserSever();
    private static final OrderItemService orderItemService = new OrderItemService();
    public static void runOrder() {
        do {
            try {
                Menu.orderMenu();
                Scanner scanner = new Scanner(System.in);
                OrderView orderView = new OrderView();
                System.out.println("\n Chọn chức năng");
                System.out.print(" ⭆ ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        orderView.addOrder();
                        break;
                    case 2:
                        OrderService.showListOrder();
                        break;
                    case 0:
                        Menu.mainMenu();
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại!");
            }
        } while (true);
    }

    private static void changeProductsAfterPay(String name) {
        productService.update();
        for(OrderItem orderItem : OrderItemService.listOrderItem) {
            if(orderItem.getName().equals(name)){
                OrderItemService.addOrderPaid(orderItem);
            }
        }

        OrderItemService.listOrderItem.removeIf(orderItem -> orderItem.getName().equals(name));
        orderItemService.update();
        runOrder();
    }

    public void addOrder() {
        boolean flag = true;
        do {
            productView.showProduct();
            System.out.println("Nhập ID sản phẩm muốn mua (nhấn 0 để quay lại menu trước đó): ");
            long id = Long.parseLong(scanner.nextLine());
            while (!productService.existProductById(id)){
                if(id == 0) {
                    runOrder();
                }
                System.out.println("ID không tồn tại! Vui lòng nhập lại ID: ");
                id = Long.parseLong(scanner.nextLine());
            }
            Product product = productService.getProductById(id);
            User user = userService.getUserById(Menu.userId);
            System.out.println("Nhập số lượng muốn mua (nhấn 0 để quay lại menu trước đó): ");
            int amount = Integer.parseInt(scanner.nextLine());
            while (amount <= 0 || amount > product.getQuantity()){
                if(amount == 0){
                    runOrder();
                }
                if(amount < 0) {
                    System.out.println("Số lượng phải là 1 số dương! Vui lòng nhập lại số lượng: ");
                }else {
                    System.out.println("Số lượng bạn mua vượt quá số lượng sản phẩm còn lại của cửa hàng! Hiện chúng tôi chỉ còn số lượng là: " + product.getQuantity());
                    System.out.println("Vui lòng nhập lại số lượng phù hợp: ");
                }
                amount = Integer.parseInt(scanner.nextLine());
            }

            OrderItem orderItem = new OrderItem(System.currentTimeMillis() / 1000,user.getName(),product.getPrice(),amount,
                    System.currentTimeMillis() / 100,product.getProductId(),product.getProductName(), product.getPrice() * amount);

            orderItemService.add(orderItem);

            if (!OrderService.checkExistNameOfOrder(user.getName())) {
                Order order = new Order(System.currentTimeMillis() / 100, user.getName(), user.getPhone(), user.getAddress());
                orderService.add(order);
            }

            orderItemService.update();
            orderService.update();

            product.setQuantity(product.getQuantity() - amount);

            System.out.println("Bạn có muốn chọn tiếp không");
            System.out.println("Nhấn 'y' để tiếp tục hoặc 'n' để thoát");
            String chose = scanner.nextLine();
            switch (chose.toLowerCase()){
                case "y":
                    addOrder();
                    break;
                case "n":
                    flag = false;
                    break;
                default:
                    System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại!");
            }
            OrderItemService.showListOrder();
        }while (flag);
    }
    public void showBill(double totalMoney) {
        do {
            try {
                System.out.println("Bạn có chắc muốn thanh toán hoá đơn này không?");
                System.out.println("( y - thanh toán hoá đơn, n - huỷ hoá đơn)");
                String choice = scanner.nextLine().toLowerCase();
                User user = userService.getUserById(Menu.userId);
                switch (choice) {
                    case "y":
                        System.out.println("Bạn đã thanh toán thành công hoá đơn:" + Valid.priceToString(totalMoney) +"!");
                        changeProductsAfterPay(user.getName());
                        break;
                    case "n":
                        orderItemService.resetListOrderItem(user.getName());
                        System.out.println("Đơn hàng đã được hủy thành công!");
                        runOrder();
                        break;
                    default:
                        System.out.println("Vui lòng chọn đúng chức năng!");
                        break;
                }
            }catch (Exception e){
                System.out.println("Chức năng không hợp lệ!");
            }
        } while (true);
    }
}
