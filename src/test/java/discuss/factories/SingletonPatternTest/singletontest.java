package discuss.factories.SingletonPatternTest;

import discuss.conf.factories.SingletonPattern.Student;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2016/04/03.
 */
public class singletontest {
    private  Student stud;
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testName() throws Exception {
        stud = Student.instance();
        //Assert.assertEquals(stud.getName(), "Test");
        Assert.assertNotNull(stud);

    }

    @After
    public void tearDown() throws Exception {


    }
}