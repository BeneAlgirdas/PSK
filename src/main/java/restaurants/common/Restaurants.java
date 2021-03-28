package restaurants.common;

import lombok.Getter;
import lombok.Setter;
import restaurants.entities.Restaurant;
import restaurants.persistence.RestaurantsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Model
@Getter @Setter
public class Restaurants implements Serializable {

    @Inject
    private RestaurantsDAO restaurantsDAO;

    private Restaurant restaurantToCreate = new Restaurant();

    private List<Restaurant> allRestaurants;
    @PostConstruct
    public void init(){
        loadRestaurants();
    }

    public void loadRestaurants() {
        this.allRestaurants = restaurantsDAO.loadAll();
    }

    public List<Restaurant> getAllRestaurants(){
        return allRestaurants;
    }
}