package discuss.conf.factories;

import discuss.domain.Category;

/**
 * Created by student on 2016/04/07.
 */
public class CategoryFactory {
    public static Category create(double stockType){
        Category categories = new Category.Builder(stockType)
                .build();
        return categories ;
    }
}
