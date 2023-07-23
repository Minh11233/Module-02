import java.util.Arrays;
import java.util.Comparator;
public class Testing {
    public static void main(String[] args) {
        Product[] productList = new Product[4];
        productList[0] = new Product(1,20000,500,"Áo Ba Lỗ");
        productList[1] = new Product(5,35000,50,"Dép lê");
        productList[2] = new Product(3,100000,3000,"Robot");
        productList[3] = new Product(10,5000,10000,"Kẹo");

        System.out.println("Pre-sort");
        for (Product product : productList) {
            System.out.println(product);
        }

        System.out.println("\nSort with price from lowest to highest");
        Comparator priceSort = new PriceSort();
        Arrays.sort(productList, priceSort);
        for (Product product : productList) {
            System.out.println(product);
        }

        System.out.println("\nSort with price from highest to lowest");
        Comparator priceSortFromHighestToLowest = new PriceSortFromHighestToLowest();
        Arrays.sort(productList, priceSortFromHighestToLowest);
        for (Product product : productList) {
            System.out.println(product);
        }

        System.out.println("\nSort with Popularity");
        Comparator Popularity = new PopularitySort();
        Arrays.sort(productList, Popularity);
        for (Product product : productList) {
            System.out.println(product);
        }

    }
}
