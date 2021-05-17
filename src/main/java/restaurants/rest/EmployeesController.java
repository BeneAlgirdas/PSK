package restaurants.rest;

import restaurants.entities.Employee;
import restaurants.entities.Restaurant;
import restaurants.persistence.RestaurantsDAO;
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
    @Inject
    private RestaurantsDAO restaurantsDAO;

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

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer employeeId,
            String employeeData) {
        try {
            Employee existingEmployee = employeesDAO.findOne(employeeId);
            if (existingEmployee == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingEmployee.setName(employeeData);
            //existingEmployee.setRestaurant(employeeData.getRestaurantId());
            employeesDAO.update(existingEmployee);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("/{id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(@PathParam("id") final Integer restaurantId,String name) {
        try {
            Employee existingEmployee = new Employee();
            Restaurant existingRestaurant = restaurantsDAO.findOne(restaurantId);
            if (existingRestaurant == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            existingEmployee.setName(name);
            existingEmployee.setRestaurant(existingRestaurant);

            employeesDAO.persist(existingEmployee);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}