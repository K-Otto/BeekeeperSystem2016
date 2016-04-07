package discuss.domain;

import java.io.Serializable;
import javax.persistence.*;
/**
 * Created by student on 2015/09/13.
 */
@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bucketID;

    private double totalStock;
    private double totalStockRemaining;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "harvestID")
    private Harvest harvests;


    private Product() {
    }

    public Product(Builder builder) {
        bucketID = builder.bucketID;
        totalStock = builder.totalStock;
        totalStockRemaining = builder.totalStockRemaining;

    }

    public static class Builder {
        private Long bucketID;
        private double totalStock;
        private double totalStockRemaining;
        private Harvest harvests;


        public Builder(double totalStock) {
            this.totalStock = totalStock;
        }


        public Builder totalStockRemaining(double value) {
            this.totalStockRemaining = value;
            return this;
        }
        public Builder id(Long value) {
            this.bucketID = value;
            return this;
        }

        public Builder harvests(Harvest value) {
            this.harvests = value;
            return this;
        }

        public Builder copy(Product value) {
            this.bucketID = value.bucketID;
            this.totalStock = value.totalStock;
            this.totalStockRemaining = value.totalStockRemaining;
            this.harvests = value.harvests;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    public Long getId() {
        return bucketID;
    }

    public Double getTotalStock() {
        return totalStock;
    }

    public Double getTotalStockRemaining() {
        return totalStockRemaining;
    }

    public Harvest getHarvests() {
        return harvests;
    }
}
