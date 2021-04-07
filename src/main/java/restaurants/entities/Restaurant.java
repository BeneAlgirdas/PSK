package restaurants.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Restaurant.findAll", query = "select a from Restaurant as a")
})
@Table(name = "RESTAURANT")
public class Restaurant {

    public Restaurant(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "restaurant")
    private List<Employee> employees = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant restaurant = (Restaurant) o;
        return Objects.equals(name, restaurant.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @ManyToMany(mappedBy = "restaurants")
    private Set<Customer> customers = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> emplyees) {
        this.employees = emplyees;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}