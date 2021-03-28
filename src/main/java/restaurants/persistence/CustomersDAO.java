package restaurants.persistence;

import restaurants.entities.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class CustomersDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Customer> loadAll() {
        return em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }

    /*public List<Customer> loadCustomersOfRestaurant(Integer restaurantId) {
        return em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }*/

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Customer customer){
        this.em.persist(customer);
    }
}