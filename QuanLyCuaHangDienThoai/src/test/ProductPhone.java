import java.util.Objects;

public class ProductPhone implements Comparable<ProductPhone> {
    private int idProduct;
    private String nameProduct;
    private String colorProduct;
    private int amountProduct;
    private double priceProduct;
    private String urlImage;
    private String sortDescription;

    public ProductPhone(int idProduct, String nameProduct, String colorProduct, int amountProduct
            , double priceProduct, String urlImage, String sortDescription) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.colorProduct = colorProduct;
        this.amountProduct = amountProduct;
        this.priceProduct = priceProduct;
        this.urlImage = urlImage;
        this.sortDescription = sortDescription;
    }

    public ProductPhone(int idProduct, String nameProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
    }

    public ProductPhone() {
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getColorProduct() {
        return colorProduct;
    }

    public void setColorProduct(String colorProduct) {
        this.colorProduct = colorProduct;
    }

    public int getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(int amountProduct) {
        this.amountProduct = amountProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getSortDescription() {
        return sortDescription;
    }

    public void setSortDescription(String sortDescription) {
        this.sortDescription = sortDescription;
    }

    @Override
    public int compareTo(ProductPhone o) {
        if (this.nameProduct.compareToIgnoreCase(o.getNameProduct()) > 0
        ||this.priceProduct > o.getPriceProduct()) {
            return 1;
        } else if (this.nameProduct.compareToIgnoreCase(o.getNameProduct()) < 0) {
            return -1;
        } else {
            if (this.priceProduct > o.getPriceProduct()) {
                return 1;
            } else if (this.priceProduct < o.getPriceProduct()) {
                return -1;
            } else {
                if (this.amountProduct > o.getAmountProduct()) {
                    return 1;
                } else if (this.amountProduct < o.getAmountProduct()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }


    @Override
    public String toString() {
        return "ProductPhone{" +
                "idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", colorProduct='" + colorProduct + '\'' +
                ", amountProduct=" + amountProduct +
                ", priceProduct=" + priceProduct +
                ", urlImage='" + urlImage + '\'' +
                ", sortDescription='" + sortDescription + '\'' +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPhone that = (ProductPhone) o;
        return idProduct == that.idProduct && amountProduct == that.amountProduct && Double.compare(that.priceProduct, priceProduct) == 0 && Objects.equals(nameProduct, that.nameProduct) && Objects.equals(colorProduct, that.colorProduct) && Objects.equals(urlImage, that.urlImage) && Objects.equals(sortDescription, that.sortDescription);
    }

    //    @Override
//    public int hashCode() {
//        return Objects.hash(idProduct, nameProduct, colorProduct, amountProduct, priceProduct, urlImage, sortDescription);
//    }
    @Override
    public int hashCode() {
        return Objects.hash(idProduct);
    }
}
