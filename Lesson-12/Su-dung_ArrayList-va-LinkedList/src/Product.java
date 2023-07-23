public class Product {
    private int ID;
    private String name;
    private int price;

    public Product() {
    }

    static int count = 0;
    public Product(String name, int price) {
        this.ID = ++count;
        this.name = name;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "ID = " + ID +
                ", Sản phẩm = " + name +
                ", Giá tiền = " + price + " VND" + "\n";
    }
}
