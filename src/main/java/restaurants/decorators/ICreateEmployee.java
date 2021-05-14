package restaurants.decorators;

import restaurants.mybatis.model.Employee;

public interface ICreateEmployee {
    int createEmployee(Employee employee);
}
