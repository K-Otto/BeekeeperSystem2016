package discuss.factories.ChainOfResponsibilityTest;

/**
 * Created by student on 2016/04/03.
 */
import discuss.Config;
import discuss.conf.factories.CreationalPattern.CarEnum;
import discuss.conf.factories.CreationalPattern.CarHandler;
import discuss.conf.factories.CreationalPattern.NissanHandler;
import discuss.conf.factories.CreationalPattern.ToyotaHandler;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by student on 2015/03/13.
 */
public class ChainofResponsibilityTest {


    @Before
    public void setUp() throws Exception {

    }

    public static CarHandler createChain() {
        ToyotaHandler car1;
        NissanHandler car2;
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        car1 = (ToyotaHandler) ctx.getBean("chain2");
        ApplicationContext ctx1 = new AnnotationConfigApplicationContext(Config.class);
        car2 = (NissanHandler) ctx1.getBean("chain1");
        car1.setSuccessor(car2);
        return car1;
    }

    @Test
    public void testName() throws Exception {
        CarHandler chain = createChain();
        chain.handleRequest(CarEnum.TOYOTA);
        Assert.assertNotNull(chain);

    }

    @After
    public void tearDown() throws Exception {


    }
}