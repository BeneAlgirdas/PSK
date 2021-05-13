package restaurants.common;

import org.mybatis.cdi.Transactional;
import restaurants.mybatis.dao.RestaurantMapper;
import restaurants.mybatis.model.Customer;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Model
public class RestaurantCustomers implements Serializable {
    @SuppressWarnings("CdiInjectionPointsInspection")
    @Inject
    private RestaurantMapper restaurantMapper;

    private Integer restaurantId;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer restaurantId = Integer.parseInt(requestParameters.get("restaurantId"));
        this.restaurantId = restaurantId;
    }

    @Transactional
    public List<Customer> getCustomers(){
        List<Customer> customers = restaurantMapper.getCustomers(this.restaurantId);
        return customers;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }
}
