package View;


import Form.Product;
import Menu.Menu;
import Sever.ProductService;
import utils.Valid;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import static Menu.Menu.confirmToDelete;
import static Menu.Menu.scanner;
import static Sever.ProductService.*;

public class ProductView {
    private static final ProductService productService = new ProductService();

    public static void runProduct() {
        do {
            Scanner scanner = new Scanner(System.in);
            ProductView managerProductView = new ProductView();
            Menu.menuProduct();
            try {
                System.out.println("\nChọn chức năng");
                System.out.print(" ⭆ ");

                int number = Integer.parseInt(scanner.nextLine());
                switch (number) {
                    case 1:
                        managerProductView.addProduct();
                        break;
                    case 2:
                        managerProductView.updateProduct();
                        break;
                    case 3:
                        managerProductView.deleteProduct();
                        break;
                    case 4:
                        managerProductView.searchProduct();
                        break;
                    case 5:
                        managerProductView.showProduct();
                        break;
                    case 8:
                        Menu.mainMenu();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Chọn chức năng không hợp lệ! Vui lòng chọn lại!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Chọn chức năng không hợp lệ! Vui lòng chọn lại!");
            }
        } while (true);
    }

    private void searchProduct() {
        ArrayList<Product> searchProduct = new ArrayList<>();
        System.out.println("Nhập thông tin cần tìm: ");
        String name = scanner.nextLine().toLowerCase();
        for (Product product : listProducts) {
            if (product.toString().toLowerCase().contains(name)) {
                searchProduct.add(product);
            }
        }
        ProductService.showSearch(searchProduct);
    }

    public void showProduct() {
        try {
            showAllProducts();
        } catch (Exception e) {
            System.out.println("Chọn chức năng không đúng!");
        }
    }

    public void addProduct() {
        int quantity = 0;
        long price = 0;
        String name = null;
        do {
            try {
                System.out.println("Nhập tên sản phẩm(sau mỗi khoảng trắng phải viết hoa chữ cái đầu tiên): ");
                name = scanner.nextLine();

                while (productService.existProductByName(name.toLowerCase()) || !Valid.isValidNameProduct(name)) {
                    if (!Valid.isValidNameProduct(name)) {
                        System.out.println("Tên không hợp lệ! Vui lòng nhập lại(sau mỗi khoảng trắng phải viết hoa chữ cái đầu tiên): ");
                    } else {
                        System.out.println("Tên đã tồn tại! Nhập tên khác: ");
                    }
                    name = scanner.nextLine();
                }
            } catch (Exception e) {
                System.out.println("Tên không hợp lệ! Vui lòng nhập lại tên!");
            }
        } while (productService.existProductByName(name));

        do {
            try {
                System.out.println("Nhập giá: ");
                price = Long.parseLong(scanner.nextLine());
                while (price <= 0) {
                    System.out.println("Giá không hợp lý! Nhập lại: ");
                    price = Long.parseLong(scanner.nextLine());
                }
            } catch (Exception e) {
                System.out.println("Giá không hợp lý! Vui lòng nhập lại giá!");
            }
        } while (price <= 0);

        do {
            try {
                System.out.println("Nhập số lượng: ");
                quantity = Integer.parseInt(scanner.nextLine());
                while (quantity < 0) {
                    System.out.println("Số lượng không hợp lý! Nhập lại: ");
                    quantity = Integer.parseInt(scanner.nextLine());
                }
            } catch (Exception e) {
                System.out.println("Số lượng không hợp lý! Vui lòng nhập lại số lượng!");
            }
        } while (quantity < 0);

        Product product = new Product(name, price, quantity);
        productService.add(product);
        System.out.println("Sản phẩm đã được thêm thành công!");
        showAllProducts();
    }


    public void updateProduct() {
        try {
            showAllProducts();
            System.out.println("* * * * * * NHẤN 0 ĐỂ QUAY LẠI MENU GẦN NHẤT * * * * * * ");
            int id = 0;
            do {
                try {
                    System.out.println("Nhập ID muốn sửa: ");
                    id = Integer.parseInt(scanner.nextLine());
                    while (!productService.existProductById(id)) {
                        if (id == 0) {
                            runProduct();
                        } else {
                            System.out.println("Không tồn tại sản phẩm có ID này! Vui lòng nhập lại ID khác: ");
                        }
                        id = Integer.parseInt(scanner.nextLine());
                    }
                } catch (Exception e) {
                    System.out.println("ID không hợp lệ!");
                }
            } while (!productService.existProductById(id));
            Product product = productService.getProductById(id);
            String name = checkNameProduct(product);
            long price = checkPriceProduct(product);
            int quantity = checkQuantity(product);

            if (name.equals("0") || Long.toString(price).equals("0") || Integer.toString(quantity).equals("0")) {
                System.out.println("Sản phẩm chưa được thay đổi!");
            } else {
                product.setProductName(name);
                product.setPrice(price);
                product.setQuantity(quantity);
                product.setUpdateDayProduct(LocalDateTime.now());
                System.out.println("Sản phẩm đã được chỉnh sửa thành công!");
                showAllProducts();
                productService.update();
            }
        } catch (Exception e) {
            System.out.println("Thông tin nhập không hợp lệ!");
        }
    }

    private int checkQuantity(Product product) {
        int quantity = 0;
        do {
            try {
                System.out.println("Nhập số lượng sản phẩm muốn sửa (bấm 0 nếu muốn thoát và quay lại menu trước đó): ");
                quantity = Integer.parseInt(scanner.nextLine());

                while (quantity <= 0 || product.getQuantity() == quantity) {
                    if (quantity == 0) {
                        runProduct();
                    } else if (product.getQuantity() == quantity) {
                        System.out.println("Số lượng thay đổi phải khác ban đầu! Vui lòng nhập lại số lượng sản phẩm: ");
                    } else {
                        System.out.println("Số lượng không thể âm! Vui lòng nhập lại số lượng: ");
                    }
                    quantity = Integer.parseInt(scanner.nextLine());
                }
            } catch (Exception e) {
                System.out.println("Số lượng không hợp lệ!");
            }
        } while (quantity <= 0 || product.getQuantity() == quantity);
        product.setQuantity(quantity);
        return quantity;
    }

    private long checkPriceProduct(Product product) {
        long price = 0;
        do {
            try {
                System.out.println("Nhập giá mới (bấm 0 nếu muốn thoát và quay lại menu trước đó): ");
                price = Long.parseLong(scanner.nextLine());

                while (price <= 0 || product.getPrice() == price) {
                    if (price == 0) {
                        runProduct();
                    } else if (product.getPrice() == price) {
                        System.out.println("Giá thay đổi phải khác ban đầu! Vui lòng nhập lại giá sản phẩm: ");
                    } else {
                        System.out.println("Giá sản phẩm không được âm! Vui lòng nhập lại giá sản phẩm: ");
                    }

                    price = Long.parseLong(scanner.nextLine());
                }
            } catch (Exception e) {
                System.out.println("Giá sản phẩm không hợp lệ!");
            }
        } while (price <= 0 || product.getPrice() == price);
        product.setPrice(price);
        return price;
    }

    private String checkNameProduct(Product product) {
        System.out.println("Nhập tên mới (bấm 0 nếu muốn thoát và quay lại menu trước đó): ");
        String name = scanner.nextLine();

        while (productService.existProductByName(name) || !Valid.isValidNameProduct(name)) {
            if (name.equals("0")) {
                runProduct();
            } else if (product.getProductName().equals(name)) {
                System.out.println("Tên thay đổi không được trùng với tên ban đầu!");
            } else if (!Valid.isValidNameProduct(name)) {
                System.out.println("Tên không hợp lệ!");
            } else {
                System.out.println("Trùng tên với sản phẩm có sẵn");
            }
            name = scanner.nextLine();
        }
        return name;
    }


    public void deleteProduct() {
        try {
            showAllProducts();
            System.out.println("Nhập ID muốn xóa: ");
            int id = Integer.parseInt(scanner.nextLine());
            while (!productService.existProductById(id)) {
                System.out.println("Không tồn tại sản phẩm có ID này! Vui lòng nhập lại ID khác: ");
                id = Integer.parseInt(scanner.nextLine());
            }
            System.out.println("Bạn có đồng ý xóa sản phẩm này không");
            confirmToDelete();
            String choie = scanner.nextLine();
            switch (choie) {
                case "1":
                    productService.removeById(id);
                    System.out.println("Sản phẩm có ID là " + id + " đã được xóa khỏi danh sách!");
                    showAllProducts();
                    break;
                case "0":
                    runProduct();
                    break;
                default:
                    System.out.println("Chọn chức năng không hợp lệ! Vui lòng chọn lại!");
                    break;
            }
        } catch (Exception e) {
            System.out.println("ID không hợp lệ!");
        }

    }
}
