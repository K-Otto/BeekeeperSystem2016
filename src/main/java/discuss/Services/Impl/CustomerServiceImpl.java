package discuss.Services.Impl;

import discuss.Services.CustomerService;
import discuss.conf.factories.CustomerFactory;
import discuss.conf.factories.PersonFactory;
import discuss.domain.Customer;
import discuss.domain.Person;
import discuss.respository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by student on 2015/09/25.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository repository;


    @Override
    public String saveCustomer(String firstname,
                               String lastname,
                               String email,
                               String address) {

        Person persons = PersonFactory
                .create(firstname, lastname, email);

        Customer customers = CustomerFactory
                .create(address, persons);
        return repository.save(customers).toString();

    }

    @Override
    public Customer getCustomer (Long id) {

        return repository.findOne(id);
    }
}

