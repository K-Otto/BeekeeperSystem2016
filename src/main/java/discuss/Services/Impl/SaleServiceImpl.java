package discuss.Services.Impl;

import discuss.Services.SaleService;
import discuss.conf.factories.*;
import discuss.domain.*;
import discuss.respository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by student on 2015/09/25.
 */
@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    SalesRepository repository;


    @Override
    public String saveSales(String salesDate,
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
                            double salary) {
        Person persons = PersonFactory
                .create(bFirstname, bLastname, bEmail);

        Beekeeper beekeepers = BeekeeperFactory
                .create(salary, persons);
        Location locations = LocationFactory
                .create(locationName, beekeepers);
        SubLocation subLocations = SubLocationFactory
                .create(subLocationName, locations);
        Harvest harvests =  HarvestFactory
                .create(harvestDate, harWeight, subLocations);
        Product buckets =  ProductFactory
                .create(bucWeight, harvests);
        Customer customers = CustomerFactory
                .create(address,persons);
        Sales sales = SalesFactory
                .create(salesDate,price, buckets,customers);

        return repository.save(sales).toString();

    }

    @Override
    public Sales getSales (Long id) {

        return repository.findOne(id);
    }
}
