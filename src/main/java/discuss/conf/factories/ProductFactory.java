package discuss.conf.factories;

import discuss.domain.Product;
import discuss.domain.Harvest;

/**
 * Created by student on 2015/09/13.
 */
public class ProductFactory {
    public static Product create(Double weight, Harvest harvests){
        Product buckets= new Product.Builder(weight)
                .harvests(harvests)
                .build();
        return buckets;
    }
}
