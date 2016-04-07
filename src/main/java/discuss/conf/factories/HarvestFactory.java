package discuss.conf.factories;

import discuss.domain.Harvest;
import discuss.domain.SubLocation;

import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public class HarvestFactory {
    public static Harvest create(String harvestDate,Double totalWeight, SubLocation subLocations){
        Harvest harvests= new Harvest.Builder(harvestDate)
                .totalWeight(totalWeight)
                .subLocations(subLocations)
                .build();
        return harvests;
    }
}
