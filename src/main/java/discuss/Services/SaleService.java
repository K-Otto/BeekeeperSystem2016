package discuss.Services;

import discuss.domain.Sales;

/**
 * Created by student on 2015/09/25.
 */
public interface SaleService {
    String saveSales(
            String salesDate,
            double price,
            double bucWeight,
            String harvestDate,
            double harWeight,
            String subLocationName,
            String locationName,
            String bFirstname,
            String bLastname,
            String bEmail,
            String address,
            double salary

    );

    Sales getSales(Long id);
}