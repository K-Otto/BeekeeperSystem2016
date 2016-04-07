package discuss.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by student on 2016/04/06.
 */
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryID;

    private double stockType;



    private Category() {
    }

    public Long getCategoryId() {
        return categoryID;
    }
    public double getstockType() {
        return stockType;
    }


    public Category(Builder builder){
        categoryID=builder.categoryID;
        stockType=builder.stockType;

    }

    public static class Builder{
        private double stockType;

        private long categoryID;
        public Builder(double stockType) {
            this.stockType = stockType;
        }


        public Builder copy(Category value){
            this.categoryID = value.categoryID;
            this.stockType =value.stockType ;

            return this;
        }

        public Category build(){
            return new Category(this);
        }
    }
}


