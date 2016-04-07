package discuss.Services;

import discuss.domain.Product;

/**
 * Created by student on 2015/09/25.
 */
public interface BucketService {
    String saveBucket(
                       double bucWeight,
                       String harvestDate,
                       double harWeight,
                       String subLocationName,
                       String locationName,
                       String bFirstname,
                       String bLastname,
                       String bEmail,
                       double salary

    );

    Product getBucket(Long id);
}