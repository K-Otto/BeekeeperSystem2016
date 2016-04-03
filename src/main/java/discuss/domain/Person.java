package discuss.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by student on 2016/04/03.
 */
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long personID;

    private String firstName;
    private String lastName;
    private String email;


    private Person() {
    }

    public Long getPersonId() {
        return personID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }

    public Person(Builder builder){
        personID=builder.personID;
        firstName=builder.firstName;
        lastName=builder.lastName;
        email=builder.email;
    }

    public static class Builder{
        private String firstName;
        private String lastName;
        private String email;
        private long personID;
        public Builder(String lastName) {
            this.lastName = lastName;
        }

        public Builder firstName(String value){
            this.firstName=value;
            return this;
        }

        public Builder email(String value){
            this.email=value;
            return this;

        }
        public Builder copy(Person value){
            this.personID = value.personID;
            this.lastName =value.lastName ;
            this.firstName=value.firstName;
            this.email=value.email;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
}

