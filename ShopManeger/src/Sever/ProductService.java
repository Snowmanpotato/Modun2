package Sever;

import Form.Product;
import Form.User;
import utils.ReadAndWrite;
import utils.Valid;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductServices{
    public static ArrayList<Product> listProducts = new ArrayList<>();

    private final String fileName = "C:\\Users\\Admin\\Desktop\\product.txt";
    @Override
    public ArrayList<Product> getProducts() {
        if (listProducts.size() == 0) {
            List<String> lists = ReadAndWrite.readFile(fileName);
            for (String product : lists
            ) {
                listProducts.add(new Product(product));
            }
            return listProducts;
        }
        return null;
    }

    @Override
    public void add(Product newProduct) {
        listProducts.add(newProduct);
        update();
    }

    @Override
    public Product getProductById(long id) {
        for (Product product : listProducts
        ) {
            if (product.getProductId() == id) {
                return product;
            }
        }
        return null;
    }
  public boolean existProductByName(String name){
      for (Product product : listProducts
      ) {
          if (product.getProductName().equalsIgnoreCase(name)) {
              return true;
          }
      }
      return false;
  }
    @Override
    public boolean existProductById(long id) {
        for (Product product : listProducts
        ) {
            if (product.getProductId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeById(long id) {
        listProducts.remove(getProductById(id));
        update();
    }
    public void updateProductById(long id, Product editProduct) {
        getProductById(id).setProductName(editProduct.getProductName());
        getProductById(id).setQuantity(editProduct.getQuantity());
        getProductById(id).setPrice(editProduct.getPrice());
        update();
    }
    public void update() {
        ReadAndWrite.writeFile(fileName, listProducts);
    }

    public static void showAllProducts() {
        if (listProducts.size() == 0) {
            System.out.println(" ");
            System.out.println("===============  Danh s??ch s???n ph???m tr???ng!  ===============");
            System.out.println(" ");
        } else {
            System.out.println("----------------------------------------------------  LIST CUSTOMER  -----------------------------------------------");

            System.out.printf("     %-15s %-15s %-10s %-15s %-24s %-24s\n", "ID", "T??n s???n ph???m", "S??? l?????ng", "Gi??", "Ng??y kh???i t???o", "Ng??y s???a");
            for (Product product : listProducts) {
                System.out.printf("%-15s %-15s %-10s %-15s %-24s %-24s\n", product.getProductId(), product.getProductName(), product.getQuantity(),
                        product.getPrice(), Valid.localDateTimeToDateWithSlash(product.getDateAdded()), Valid.localDateTimeToDateWithSlash(product.getUpdateDayProduct()));
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------------");
            System.out.println(" ");
        }
    }
    public static void showSearch(ArrayList<Product> list) {
        if (list.size() == 0) {
            System.out.println(" ");
            System.out.println("==================  Danh s??ch t??m ki???m tr???ng!  ==================");
            System.out.println(" ");
        } else {
            System.out.println("------------------------- DANH S??CH T??M KI???M -------------------------");
            System.out.printf("*%-69s*\n", "");
            System.out.printf("*        %-16s %-15s %-15s %-12s*\n", "ID", "T??n s???n ph???m", "Gi??", "S??? l?????ng");
            System.out.printf("*%-69s*\n", "");

            for (Product product : list) {
                System.out.printf("*        %-16s %-15s %-17s %-10s*\n", product.getProductId(), product.getProductName(), Valid.priceToString(product.getPrice()), product.getQuantity());
            }
            System.out.println(" ");
            System.out.println("-----------------------------------------------------------------------");
        }
    }
}
