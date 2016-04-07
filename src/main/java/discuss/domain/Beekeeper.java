package discuss.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by student on 2015/09/13.
 */
@Entity
public class Beekeeper implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long beekeeperID;

    private double salary;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "beeID")
    private Person persons;


    private Beekeeper() {
    }




    public Beekeeper (Builder‭ builder)
    {
        salary=builder.salary;
        beekeeperID=builder.beekeeperID;
        persons=builder.persons;
    }

    public static class Builder‭{
        private long beekeeperID;
        private double salary;
        private Person persons;


        public Builder‭(Double salary) {
            this.salary= salary;
        }

        public Builder‭ ID(Long value‭){
            this.beekeeperID = value‭;
            return this;
        }

        public Builder‭ persons(Person value){
            this.persons=value;
            return this;
        }

        public Builder‭ copy(Beekeeper value){
            this.beekeeperID=value.beekeeperID;
            this.salary=value.salary;
            this.persons=value.persons;
            return this;
        }
        public Beekeeper build(){
            return new Beekeeper (this);
        }
    }
    public long getBeekeeperID() {
        return beekeeperID;
    }
    public double getSalary‭‭() {
        return salary;
    }

    public Person getPersons(){
        return persons;
    }
}