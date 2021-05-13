package restaurants.rest;

import restaurants.entities.Employee;
import restaurants.rest.contracts.EmployeeDto;
import restaurants.persistence.EmployeesDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/employees")
public class EmployeesController {

    @Inject
    private EmployeesDAO employeesDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Employee employee = employeesDAO.findOne(id);
        if (employee == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(employee.getName());
        employeeDto.setRestaurantId(employee.getRestaurant().getId());

        return Response.ok(employeeDto).build();
    }
//
//    @Path("/{id}")
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Transactional
//    public Response update(
//            @PathParam("id") final Integer employeeId,
//            EmployeeDto employeeData) {
//        try {
//            Employee existingEmployee = employeesDAO.findOne(employeeId);
//            if (existingEmployee == null) {
//                return Response.status(Response.Status.NOT_FOUND).build();
//            }
//            existingEmployee.setName(employeeData.getName());
//            existingEmployee.setRestaurant(employeeData.getRestaurantId());
//            employeesDAO.update(existingEmployee);
//            return Response.ok().build();
//        } catch (OptimisticLockException ole) {
//            return Response.status(Response.Status.CONFLICT).build();
//        }
//    }
}