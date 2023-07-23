package Entity;

public class Product {
    private int id;
    private String productName;
    private int price;
    private static int productCount = 100;
    private int CategoryID;
    public Product(String name, int price) {
        this.productName = name;
        this.price = price;
        this.id = ++productCount;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return productName;
    }

    public void setName(String name) {
        this.productName = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    @Override
    public String toString() {
        return "ID: " + id + " - Sản phẩm: " + productName + " Giá tiền là: " + price ;
    }
}
