package restaurants.common;

import lombok.Getter;
import lombok.Setter;
import restaurants.entities.Customer;
import restaurants.persistence.CustomersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Model
@Getter @Setter
public class Customers implements Serializable {

    @Inject
    private CustomersDAO customersDAO;

    private Customer customerToCreate = new Customer();

    private List<Customer> allCustomers;
    @PostConstruct
    public void init(){
        loadCustomers();
    }

    public void loadCustomers() {
        this.allCustomers = customersDAO.loadAll();
    }

    public List<Customer> getAllCustomers(){
        return allCustomers;
    }

    public Customer getCustomerToCreate() {
        return customerToCreate;
    }

    public void setCustomerToCreate(Customer customerToCreate) {
        this.customerToCreate = customerToCreate;
    }
}