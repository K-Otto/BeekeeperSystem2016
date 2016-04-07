package discuss.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * Created by student on 2015/09/13.
 */
@Entity
public class Harvest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long harvestID;

    private String harvestDate ;
    private Double totalWeight;
    private Double totalWeightRemaining;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="subLocID")
    private SubLocation  subLocations;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="categoryID")
    private Category  categories;


    private  Harvest  () {
    }

    public Harvest(Builder builder) {
        harvestID=builder.harvestID;
        harvestDate=builder.harvestDate  ;
        totalWeight=builder.totalWeight;
        totalWeightRemaining=builder.totalWeightRemaining;
        subLocations=builder.subLocations;
        categories=builder.categories;
    }
    public static class Builder{
        private Long harvestID;
        private String harvestDate  ;
        private Double totalWeight;
        private Double totalWeightRemaining;
        private SubLocation  subLocations;
        private Category  categories;

        public Builder(String harvestDate  ) {
            this.harvestDate  = harvestDate  ;
        }

        public Builder id(Long value){
            this.harvestID = value;
            return this;
        }
        public Builder totalWeight(Double value){
            this.totalWeight = value;
            return this;
        }
        public Builder totalWeightRemaining(Double value){
            this.totalWeightRemaining = value;
            return this;
        }


        public Builder subLocations(SubLocation value){
            this.subLocations=value;
            return this;
        }
        public Builder categories(Category value){
            this.categories=value;
            return this;
        }

        public Builder copy(Harvest  value){
            this.harvestID = value.harvestID;
            this.harvestDate  =value.harvestDate  ;
            this.totalWeight  =value.totalWeight  ;
            this.totalWeightRemaining  =value.totalWeightRemaining  ;
            this.subLocations=value.subLocations;
            this.categories=value.categories;
            return this;
        }
        public Harvest  build(){
            return new Harvest  (this);
        }
    }
    public Long getId() {
        return harvestID;
    }

    public String getHarvestDate () {
        return harvestDate;
    }

    public Double getWeight() {
        return totalWeight;
    }
    public Double gettotalWeightRemaining() {
        return totalWeightRemaining;
    }

    public SubLocation getSubLocation() {
        return subLocations;
    }
    public Category getCategory() {
        return categories;
    }
}

