package restaurants.common;

import restaurants.decorators.ICreateEmployee;
import restaurants.entities.Employee;
import restaurants.mybatis.dao.EmployeeMapper;
import restaurants.persistence.OptimisticLock;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@RequestScoped
public class EmployeeCreator implements ICreateEmployee {
    @SuppressWarnings("CdiInjectionPointsInspection")
    @Inject
    EmployeeMapper employeeMapper;
    @Inject
    private OptimisticLock optimisticLock;
    @Override
    public int createEmployee(Employee employee) {
        optimisticLock.create(employee);
        return 0;
    }
}
