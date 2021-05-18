package restaurants.common;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class SmallMoney implements IWagePolicy {
    @Override
    public int GetWage() {
        return 69;
    }
}
