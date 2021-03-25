package restaurants.entities;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Model
public class Customers implements Serializable {
    private List<Customer> allCustomers;
    @PostConstruct
    public void init(){
        loadCustomers();
    }

    public void loadCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Jurgis"));
        customers.add(new Customer("Antanas"));
        customers.add(new Customer("Aloyzas"));
        customers.add(new Customer("Martynas"));
        this.allCustomers = customers;
    }

    public List<Customer> getAllCustomers(){
        return allCustomers;
    }
}