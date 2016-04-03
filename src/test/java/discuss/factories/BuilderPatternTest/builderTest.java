package discuss.factories.BuilderPatternTest;


import discuss.Config;
import discuss.conf.factories.BuilderPattern.Person;
import discuss.conf.factories.BuilderPattern.PersonDirector;
import discuss.conf.factories.BuilderPattern.PersonOne;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by student on 2016/04/03.
 */
public class builderTest {
    PersonOne one;
    Person pers;
    @Before
    public void setUp() throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        one = (PersonOne)ctx.getBean("builder2");
        PersonDirector pd = new PersonDirector(one);
        pd.constructPerson();
        pers = pd.getPerson();

    }

    @Test
    public void testName() throws Exception {


        Assert.assertEquals(pers.getAge(), 23);

    }

    @After
    public void tearDown() throws Exception {


    }
}