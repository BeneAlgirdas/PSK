package restaurants.common;

import restaurants.entities.Restaurant;
import restaurants.persistence.RestaurantsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
public class Restaurants implements Serializable {

    @Inject
    private RestaurantsDAO restaurantsDAO;

    private Restaurant restaurantToCreate = new Restaurant();

    private List<Restaurant> allRestaurants;
    @PostConstruct
    public void init(){
        loadRestaurants();
    }

    @Transactional
    public String createRestaurant(){
        this.restaurantsDAO.persist(restaurantToCreate);
        return "index?faces-redirect=true";
    }

    public void loadRestaurants() {
        this.allRestaurants = restaurantsDAO.loadAll();
    }

    public List<Restaurant> getAllRestaurants(){
        return allRestaurants;
    }

    public RestaurantsDAO getRestaurantsDAO() {
        return restaurantsDAO;
    }

    public void setRestaurantsDAO(RestaurantsDAO restaurantsDAO) {
        this.restaurantsDAO = restaurantsDAO;
    }

    public Restaurant getRestaurantToCreate() {
        return restaurantToCreate;
    }

    public void setRestaurantToCreate(Restaurant restaurantToCreate) {
        this.restaurantToCreate = restaurantToCreate;
    }

    public void setAllRestaurants(List<Restaurant> allRestaurants) {
        this.allRestaurants = allRestaurants;
    }
}