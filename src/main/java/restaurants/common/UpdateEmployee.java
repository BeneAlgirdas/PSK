package restaurants.common;

import org.mybatis.cdi.Transactional;
import restaurants.mybatis.dao.EmployeeMapper;
import restaurants.mybatis.model.Employee;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Map;

@Model
public class UpdateEmployee implements Serializable {
    @SuppressWarnings("CdiInjectionPointsInspection")
    @Inject
    private EmployeeMapper employeeMapper;

    private Employee employeeToUpdate;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer employeeId = Integer.parseInt(requestParameters.get("employeeId"));
        this.employeeToUpdate = employeeMapper.selectByPrimaryKey(employeeId);
    }

    @Transactional
    public String updateEmployeeName(){
        employeeMapper.updateByPrimaryKey(employeeToUpdate);

        return "/page1.xhtml?faces-redirect=true&restaurantId=" + employeeToUpdate.getRestaurantId();
    }

    public Employee getEmployeeToUpdate() {
        return employeeToUpdate;
    }

    public void setEmployeeToUpdate(Employee employeeToUpdate) {
        this.employeeToUpdate = employeeToUpdate;
    }
}