package discuss.factories.FactoryPatternTest;

/**
 * Created by student on 2016/04/03.
 */
import discuss.Config;
import discuss.conf.factories.FactoryPattern.Transport;
import discuss.conf.factories.FactoryPattern.TransportFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by student on 2015/03/13.
 */
public class factorytest {
    private  TransportFactory trans;
    private  Transport vehicle1;
    private Transport vehicle2;
    @Before
    public void setUp() throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        trans = (TransportFactory)ctx.getBean("fact");

    }

    @Test
    public void testName() throws Exception {
        vehicle1 =  trans.getTransport("Audi");
        vehicle2 =  trans.getTransport("Raleigh");

        Assert.assertEquals("Vehicle Audi Wheels", 4, vehicle1.numWheels());

        Assert.assertEquals("Vehicle Raleigh Wheels", 2, vehicle2.numWheels());

    }

    @After
    public void tearDown() throws Exception {


    }
}