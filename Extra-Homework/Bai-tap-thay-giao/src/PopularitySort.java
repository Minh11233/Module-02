import java.util.Comparator;
public class PopularitySort implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getPopularity() - o2.getPopularity();
    }
}
