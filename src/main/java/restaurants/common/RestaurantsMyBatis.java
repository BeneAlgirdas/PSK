package restaurants.common;

import restaurants.mybatis.dao.RestaurantMapper;
import restaurants.mybatis.model.Restaurant;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class RestaurantsMyBatis {
    @SuppressWarnings("CdiInjectionPointsInspection")
    @Inject
    private RestaurantMapper restaurantMapper;

    private List<Restaurant> allRestaurants;

    private Restaurant restaurantToCreate = new Restaurant();

    @PostConstruct
    public void init() {
        this.loadAllRestaurants();
    }

    private void loadAllRestaurants() {
        this.allRestaurants = restaurantMapper.selectAll();
    }

    @Transactional
    public String createRestaurant() {
        restaurantMapper.insert(restaurantToCreate);
        return "/index?faces-redirect=true";
    }

    public RestaurantMapper getRestaurantMapper() {
        return restaurantMapper;
    }

    public void setRestaurantMapper(RestaurantMapper restaurantMapper) {
        this.restaurantMapper = restaurantMapper;
    }

    public List<Restaurant> getAllRestaurants() {
        return allRestaurants;
    }

    public void setAllRestaurants(List<Restaurant> allRestaurants) {
        this.allRestaurants = allRestaurants;
    }

    public Restaurant getRestaurantToCreate() {
        return restaurantToCreate;
    }

    public void setRestaurantToCreate(Restaurant restaurantToCreate) {
        this.restaurantToCreate = restaurantToCreate;
    }
}
