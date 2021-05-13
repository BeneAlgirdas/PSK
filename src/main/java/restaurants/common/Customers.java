package restaurants.common;

import restaurants.entities.Customer;
import restaurants.entities.Restaurant;
import restaurants.persistence.CustomersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Model
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

    public CustomersDAO getCustomersDAO() {
        return customersDAO;
    }

    public void setCustomersDAO(CustomersDAO customersDAO) {
        this.customersDAO = customersDAO;
    }

    public void setAllCustomers(List<Customer> allCustomers) {
        this.allCustomers = allCustomers;
    }
}