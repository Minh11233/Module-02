package Entity;

public class Order {
    private String customerName;
    private String productName;
    private int price;
    private int quantity;
    private int Date;

    public Order(String customerName, String productName, int price, int quantity, int date) {
        this.customerName = customerName;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        Date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDate() {
        return Date;
    }

    public void setDate(int date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "INVOICE " +
                "customerName='" + customerName + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", Date=" + Date + "\n";
    }
}
