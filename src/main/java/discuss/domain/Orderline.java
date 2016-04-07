package discuss.domain;

import javax.persistence.*;

/**
 * Created by student on 2016/04/06.
 */
public class Orderline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long salesID;
    private double quantity;
    private double unitPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bucketID")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "custID")
    private Order order;


    private Orderline() {
    }

    public Orderline(Builder builder) {
        salesID = builder.salesID;
        unitPrice=builder.unitPrice;
        quantity = builder.quantity;
        order = builder.order;
        product=builder.product;
    }

    public static class Builder {
        private Long salesID;
        private double quantity;
        private double unitPrice;
        private Product product;
        private Order order;


        public Builder(double quantity) {
            this.quantity = quantity;
        }

        public Builder id(Long value) {
            this.salesID = value;
            return this;
        }

        public Builder unitPrice(double value) {
            this.unitPrice = value;
            return this;
        }

        public Builder order(Order value) {
            this.order = value;
            return this;
        }

        public Builder product(Product value) {
            this.product = value;
            return this;
        }

        public Builder copy(Orderline value) {
            this.salesID = value.salesID;
            this.quantity = value.quantity;
            this.unitPrice = value.unitPrice;

            this.order = value.order;
            this.product = value.product;
            return this;
        }

        public Orderline build() {
            return new Orderline(this);
        }
    }

    public Long getId() {
        return salesID;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }
}

