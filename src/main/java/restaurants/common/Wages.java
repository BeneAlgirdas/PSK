package restaurants.common;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class Wages {
    @Inject
    IWagePolicy wagePolicy;

    public int calcWage() {
        return wagePolicy.GetWage();
    }
}
