package restaurants.common;

import restaurants.entities.Employee;
import restaurants.interceptors.LoggedInvocation;
import restaurants.persistence.EmployeesDAO;
import restaurants.persistence.OptimisticLock;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
public class UpdateEmployeeEM implements Serializable {
    private Employee employee;

    @Inject
    private EmployeesDAO employeesDAO;
    @Inject
    private OptimisticLock optimisticLock;

    @PostConstruct
    private void init() {
        System.out.println("UpdateEmployeeDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer employeeId = Integer.parseInt(requestParameters.get("employeeId"));
        this.employee = optimisticLock.find(employeeId);
    }

    @LoggedInvocation
    @Transactional
    public String updateEmployeeName() {
        try{
            optimisticLock.merge(this.employee);
        } catch (OptimisticLockException e) {
            System.out.println("OptimisticLock Exception!");
            return "/employeeEdit.xhtml?faces-redirect=true&employeeId=" + this.employee.getId() + "&error=optimistic-lock-exception";
        }
        return "page1.xhtml?restaurantId=" + this.employee.getRestaurant().getId() + "&faces-redirect=true";
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeesDAO getEmployeesDAO() {
        return employeesDAO;
    }

    public void setEmployeesDAO(EmployeesDAO employeesDAO) {
        this.employeesDAO = employeesDAO;
    }
}
