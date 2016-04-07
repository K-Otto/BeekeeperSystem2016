package discuss.domain;

import javax.persistence.*;

/**
 * Created by student on 2016/04/06.
 */
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long salesID;
    private String SalesDate;



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "custID")
    private Customer customers;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "custID")
    private Salesman salesman;

    private Order() {
    }

    public Order(Builder builder) {
        salesID = builder.salesID;
        SalesDate = builder.SalesDate;
        customers = builder.customers;
        salesman = builder.salesman;

    }

    public static class Builder {
        private Long salesID;
        private String SalesDate;
        private Double price;
        private Customer customers;
        private Salesman salesman;



        public Builder(String SalesDate) {
            this.SalesDate = SalesDate;
        }

        public Builder id(Long value) {
            this.salesID = value;
            return this;
        }



        public Builder customers(Customer value) {
            this.customers = value;
            return this;
        }

        public Builder salesman(Salesman value) {
            this.salesman = value;
            return this;
        }



        public Builder copy(Order value) {
            this.salesID = value.salesID;
            this.SalesDate = value.SalesDate;


            this.customers = value.customers;
            this.salesman = value.salesman;

            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    public Long getId() {
        return salesID;
    }

    public String getSalesDate() {
        return SalesDate;
    }


    public Customer getCustomers() {
        return customers;
    }

    public Salesman getSalesman() {
        return salesman;
    }


}
