package discuss.conf.factories.BuilderPattern;

/**
 * Created by student on 2016/04/03.
 */
public class PersonOne implements PersonBuilder{

    private Person person;

    public PersonOne(){
        person = new Person();
    }

    public void buildFirstName() {
        person.setFirstName("Tracy");
    }

    public void buildLastName() {
        person.setLastName("Robb");
    }

    public void buildAge() {
        person.setAge(23);

    }

    public Person getPerson() {
        return person;
    }

}
