package discuss.conf.factories;

import discuss.domain.Customer;
import discuss.domain.Order;
import discuss.domain.Salesman;

/**
 * Created by student on 2016/04/07.
 */
public class OrderFactory {
    public static Order create(String salesDate, Customer customers, Salesman salesman){
        Order order= new Order.Builder(salesDate)
                .customers(customers)
                .salesman(salesman)
                .build();
        return order;
    }
}

