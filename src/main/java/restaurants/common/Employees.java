package restaurants.common;

import lombok.Getter;
import lombok.Setter;
import restaurants.entities.Employee;
import restaurants.entities.Restaurant;
import restaurants.persistence.EmployeesDAO;
import restaurants.persistence.RestaurantsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Model
@Getter @Setter
public class Employees implements Serializable {

    @Inject
    private EmployeesDAO employeesDAO;
    @Inject
    private RestaurantsDAO restaurantsDAO;

    private Integer restaurantId;

    private Employee employeeToCreate = new Employee();

    /*private List<Employee> allEmployees;*/
    private List<Employee> restaurantEmployees = new ArrayList<>();
    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer restaurantId = Integer.parseInt(requestParameters.get("restaurantId"));
        this.restaurantId = restaurantId;
        loadEmployees(restaurantId);
    }

    @Transactional
    public String createEmployee(){
        Restaurant restaurant = restaurantsDAO.findOne(this.restaurantId);
        employeeToCreate.setRestaurant(restaurant);
        this.employeesDAO.persist(employeeToCreate);
        return "page1?faces-redirect=true&restaurantId=" + restaurant.getId();
    }

    private void loadEmployees(Integer restaurantId) {

        this.restaurantEmployees = employeesDAO.loadRestaurantEmployees(restaurantId);
    }
}