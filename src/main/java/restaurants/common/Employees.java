package restaurants.common;

import restaurants.entities.Employee;
import restaurants.entities.Restaurant;
import restaurants.interceptors.LoggedInvocation;
import restaurants.persistence.EmployeesDAO;
import restaurants.persistence.OptimisticLock;
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
public class Employees implements Serializable {

    @Inject
    private EmployeesDAO employeesDAO;
    @Inject
    private RestaurantsDAO restaurantsDAO;
    @Inject
    private OptimisticLock optimisticLock;
    private Integer restaurantId;
    @Inject
    EmployeeCreator creator;
//    private Employee employeeToCreate = new Employee();

    private restaurants.mybatis.model.Employee emplolyeeToCreate = new restaurants.mybatis.model.Employee();
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

    @LoggedInvocation
    @Transactional
    public String createEmployee() {
        Restaurant restaurant = restaurantsDAO.findOne(this.restaurantId);
        emplolyeeToCreate.setRestaurantId(restaurantId);
//        creator.createEmployee(emplolyeeToCreate);
        System.out.println("create employee!");
        var employee = new Employee();
        employee.setVersion(0);
        employee.setRestaurant(restaurant);
        employee.setName(emplolyeeToCreate.getName());
        optimisticLock.create(employee);

//        employeeToCreate.setRestaurant(restaurant);
//        this.employeesDAO.persist(employeeToCreate);
//        return "page1?faces-redirect=true&restaurantId=" + restaurant.getId();
        return "page1?faces-redirect=true&restaurantId=" + restaurant.getId();
    }

    private void loadEmployees(Integer restaurantId) {

        this.restaurantEmployees = employeesDAO.loadRestaurantEmployees(restaurantId);
    }

    public EmployeesDAO getEmployeesDAO() {
        return employeesDAO;
    }

    public void setEmployeesDAO(EmployeesDAO employeesDAO) {
        this.employeesDAO = employeesDAO;
    }

    public RestaurantsDAO getRestaurantsDAO() {
        return restaurantsDAO;
    }

    public void setRestaurantsDAO(RestaurantsDAO restaurantsDAO) {
        this.restaurantsDAO = restaurantsDAO;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public EmployeeCreator getCreator() {
        return creator;
    }

    public void setCreator(EmployeeCreator creator) {
        this.creator = creator;
    }

    public restaurants.mybatis.model.Employee getEmplolyeeToCreate() {
        return emplolyeeToCreate;
    }

    public void setEmplolyeeToCreate(restaurants.mybatis.model.Employee emplolyeeToCreate) {
        this.emplolyeeToCreate = emplolyeeToCreate;
    }


    //    public Employee getEmployeeToCreate() {
//        return employeeToCreate;
//    }
//
//    public void setEmployeeToCreate(Employee employeeToCreate) {
//        this.employeeToCreate = employeeToCreate;
//    }

    public List<Employee> getRestaurantEmployees() {
        return restaurantEmployees;
    }

    public void setRestaurantEmployees(List<Employee> restaurantEmployees) {
        this.restaurantEmployees = restaurantEmployees;
    }
}