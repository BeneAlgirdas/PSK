package restaurants.common;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;

@Alternative
@RequestScoped
public class BigMoney implements IWagePolicy {
    @Override
    public int GetWage() {
        return 500;
    }
}
