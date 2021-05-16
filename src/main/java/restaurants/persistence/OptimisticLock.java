package restaurants.persistence;

import restaurants.entities.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class OptimisticLock {
    @PersistenceContext
    @RequestScoped
    private EntityManager manager;

    public void create(Employee employee) {
        manager.persist(employee);
    }

    public Employee find(Integer id){
        return manager.find(Employee.class, id);
    }

    public Employee merge(Employee employee) {
       return manager.merge(employee);
    }
}
