package discuss.conf.factories.BuilderPattern;

/**
 * Created by student on 2016/04/03.
 */
public class PersonDirector {

    private PersonBuilder pb = null;

    public PersonDirector(PersonBuilder pb)
    {
        this.pb = pb;
    }

    public void constructPerson()
    {
        pb.buildFirstName();
        pb.buildLastName();
        pb.buildAge();
    }

    public Person getPerson()
    {
        return pb.getPerson();
    }

}