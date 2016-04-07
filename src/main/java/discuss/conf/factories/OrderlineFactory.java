package discuss.conf.factories;

import discuss.domain.Order;
import discuss.domain.Orderline;
import discuss.domain.Product;

/**
 * Created by student on 2016/04/07.
 */
public class OrderlineFactory {
    public static Orderline create(double unitPrice,double quantity, Product product, Order order){
        Orderline sales= new Orderline.Builder(quantity)
                .unitPrice(unitPrice)
                .order(order)
                .product(product)
                .build();
        return sales;
    }
}