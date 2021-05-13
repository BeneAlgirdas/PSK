package restaurants.persistence;

import restaurants.entities.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class EmployeesDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Employee> loadAll() {
        return em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }

    public List<Employee> loadRestaurantEmployees(Integer restaurantId) {
        return em.createNamedQuery("Employee.getRestaurantEmployees", Employee.class)
                .setParameter("restaurantId", restaurantId)
                .getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Employee employee){
        this.em.persist(employee);
    }

    public Employee findOne(Integer id){
        return em.find(Employee.class, id);
    }

    public Employee update(Employee employee){
        return em.merge(employee);
    }
}