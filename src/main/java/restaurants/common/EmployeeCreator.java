package restaurants.common;

import restaurants.decorators.ICreateEmployee;
import restaurants.mybatis.dao.EmployeeMapper;
import restaurants.mybatis.model.Employee;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class EmployeeCreator implements ICreateEmployee {
    @Inject
    EmployeeMapper employeeMapper;
    @Override
    public int createEmployee(Employee employee) {
        return employeeMapper.insert(employee);
    }
}
