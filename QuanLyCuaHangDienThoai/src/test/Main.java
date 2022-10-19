import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Custumer custumer = new Custumer();
//        System.out.println("Nhập tên khách hàng");
//        custumer.setNameCustumer(scanner.nextLine());
//        custumer.setIdCustumer(custumer.hashCode());

//        ProductPhone phone1 = new ProductPhone();
//        phone1.setIdProduct(phone1.hashCode());
//        System.out.println("Nhập tên sản phẩm");
//        phone1.setNameProduct(scanner.nextLine());
//        System.out.println("Nhập số lượng sản phẩm");
//        phone1.setAmountProduct(scanner.nextInt());
//        System.out.println("Nhập giá sản phẩm");
//        phone1.setPriceProduct(scanner.nextDouble());

        Custumer custumer = new Custumer();
        custumer.setNameCustumer("Loi");
        custumer.setIdCustumer(custumer.hashCode());

        ProductPhone phone1 = new ProductPhone();
        phone1.setIdProduct(phone1.hashCode());
        phone1.setNameProduct("Iphone");
        phone1.setAmountProduct(2);
        phone1.setPriceProduct(200);
        ProductPhone phone2 = new ProductPhone();
        phone2.setIdProduct(phone1.hashCode());
        phone2.setNameProduct("Iphone11");
        phone2.setAmountProduct(2);
        phone2.setPriceProduct(200);
        ProductPhone phone3 = new ProductPhone();
        phone3.setIdProduct(phone1.hashCode());
        phone3.setNameProduct("I");
        phone3.setAmountProduct(5);
        phone3.setPriceProduct(200);
        ProductPhone phone4 = new ProductPhone();
        phone4.setIdProduct(phone1.hashCode());
        phone4.setNameProduct("I");
        phone4.setAmountProduct(1);
        phone4.setPriceProduct(200);



        ArrayList<ProductPhone> listPhone = new ArrayList<>();
        listPhone.add(phone1);
        listPhone.add(phone2);
        listPhone.add(phone3);
        listPhone.add(phone4);

        Order order1 = new Order();
        order1.setIdOrder(order1.hashCode());
        order1.setListProductPhone(listPhone);
        order1.setCustumer(custumer);
        order1.getTotalOrder();


        System.out.printf("%.2f\n",order1.getTotalOrder());
        System.out.println(custumer.hashCode());
        order1.sortProduct();
        System.out.println(order1);
        System.out.println(listPhone);

        System.out.println(order1.findProductByProductName("iphone"));;
    }
}
