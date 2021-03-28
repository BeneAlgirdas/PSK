package restaurants.common;

import restaurants.entities.Customer;
import restaurants.persistence.CustomersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
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

    @Transactional
    public String createCustomer(){
        this.customersDAO.persist(customerToCreate);
        return "success";
    }

    public Customer getCustomerToCreate() {
        return customerToCreate;
    }

    public void setPlayerToCreate(Customer customerToCreate) {
        this.customerToCreate = customerToCreate;
    }
}