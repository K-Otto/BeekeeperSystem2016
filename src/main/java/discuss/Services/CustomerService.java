package discuss.Services;

import discuss.domain.Customer;

/**
 * Created by student on 2015/09/25.
 */
public interface CustomerService {
    String saveCustomer(String firstname,
                        String lastname,
                        String email,
                        String address
    );

    Customer getCustomer(Long id);
}
