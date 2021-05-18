package restaurants.decorators;

import restaurants.entities.Employee;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class EmployeeDecorator implements ICreateEmployee {

    @Inject @Delegate @Any
    ICreateEmployee employeeCreator;
    public int createEmployee(Employee employee) {
        if (employee.getName().equals("Programuotojas")) {
            System.out.println("geekas :(");
        }
        return employeeCreator.createEmployee(employee);
    }
}