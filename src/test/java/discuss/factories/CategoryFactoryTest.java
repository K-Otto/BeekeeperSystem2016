package discuss.factories;

import discuss.conf.factories.CategoryFactory;
import discuss.domain.Category;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by student on 2016/04/07.
 */
public class CategoryFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Category category = CategoryFactory.create(11.00);
        Assert.assertEquals(category.getstockType(), 11.00);
    }

    @Test
    public void testUpdate() throws Exception {
        Category category = CategoryFactory.create(11.00);
        Assert.assertEquals(category.getstockType(),11.00);
        Category newCategory = new Category
                .Builder(12.99)
                .build();
        Assert.assertEquals(newCategory.getstockType(),12.99);


    }
}