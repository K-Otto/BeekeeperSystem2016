package discuss.conf.factories.BuilderPattern;

/**
 * Created by student on 2016/04/03.
 */
public interface PersonBuilder {

    public void buildFirstName();
    public void buildLastName();
    public void buildAge();
    public Person getPerson();

}