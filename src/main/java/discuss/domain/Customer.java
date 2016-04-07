package discuss.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by student on 2015/09/13.
 */
@Entity
public class Customer  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerID;

    private String address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "beeID")
    private Person persons;


    private Customer() {
    }


    public Customer(Builder‭ builder) {
        address = builder.address;
        customerID = builder.customerID;
        persons = builder.persons;
    }

    public static class Builder‭ {
        private long customerID;
        private String address;
        private Person persons;


        public Builder‭(String address) {
            this.address = address;
        }

        public Builder‭ ID(Long value‭) {
            this.customerID = value‭;
            return this;
        }

        public Builder‭ persons(Person value) {
            this.persons = value;
            return this;
        }

        public Builder‭ copy(Customer value) {
            this.customerID = value.customerID;
            this.address = value.address;
            this.persons = value.persons;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    public long getCustomerID() {
        return customerID;
    }

    public String getAddress() {
        return address;
    }

    public Person getPersons() {
        return persons;
    }
}
