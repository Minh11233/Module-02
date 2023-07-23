public class Product {
    protected int popularity;
    protected int price;
    protected int Purchase;
    protected String name;

    public Product(int popularity, int price, int Purchase, String name) {
        this.popularity = popularity;
        this.price = price;
        this.Purchase = Purchase;
        this.name = name;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPurchase() {
        return Purchase;
    }

    public void setPurchase(int purchase) {
        Purchase = purchase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sản phẩm" + getName() +" có mức độ phổ biến là: " + getPopularity() + " với mức giá: " + getPrice() + " với lượt mua: " + getPopularity();
    }
}
