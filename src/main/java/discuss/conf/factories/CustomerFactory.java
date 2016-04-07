package discuss.conf.factories;

import discuss.domain.Customer;
import discuss.domain.Person;

/**
 * Created by student on 2015/09/13.
 */
public class CustomerFactory {

        public static Customer create( String address, Person persons){
            Customer customers = new Customer.Builder‭(address)
                    .persons(persons)
                    .build();
            return customers ;
        }
    }
