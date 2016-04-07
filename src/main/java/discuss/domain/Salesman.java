package discuss.domain;

import javax.persistence.*;

/**
 * Created by student on 2016/04/06.
 */
public class Salesman {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long salesmanID;

    private double salary;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "beeID")
    private Person persons;


    private Salesman() {
    }


    public Salesman(Builder‭ builder) {
        salary = builder.salary;
        salesmanID = builder.salesmanID;
        persons = builder.persons;
    }

    public static class Builder‭ {
        private long salesmanID;
        private double salary;
        private Person persons;


        public Builder‭(Double salary) {
            this.salary = salary;
        }

        public Builder‭ ID(Long value‭) {
            this.salesmanID = value‭;
            return this;
        }

        public Builder‭ persons(Person value) {
            this.persons = value;
            return this;
        }

        public Builder‭ copy(Salesman value) {
            this.salesmanID = value.salesmanID;
            this.salary = value.salary;
            this.persons = value.persons;
            return this;
        }

        public Salesman build() {
            return new Salesman(this);
        }
    }

    public long getSalesmanID() {
        return salesmanID;
    }

    public double getSalary‭‭() {
        return salary;
    }

    public Person getPersons() {
        return persons;
    }
}
