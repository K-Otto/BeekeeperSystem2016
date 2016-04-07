package discuss.respository;

import discuss.domain.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/09/13.
 */
public interface BucketRepository extends CrudRepository<Product,Long> {
}
