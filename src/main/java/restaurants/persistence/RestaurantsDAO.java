package restaurants.persistence;

import restaurants.entities.Restaurant;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class RestaurantsDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Restaurant> loadAll() {
        return em.createNamedQuery("Restaurant.findAll", Restaurant.class).getResultList();
    }

    public Restaurant findOne(Integer id){
        return em.find(Restaurant.class, id);
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Restaurant restaurant){
        this.em.persist(restaurant);
    }
}