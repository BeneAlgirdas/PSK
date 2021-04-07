package restaurants.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "Customer.findAll", query = "select a from Customer as a")
})
@Table(name = "CUSTOMER")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "CUSTOMER_RESTAURANT",
            joinColumns = { @JoinColumn(name = "CUSTOMER_ID") },
            inverseJoinColumns = { @JoinColumn(name = "RESTAURANT_ID") }
    )
    Set<Restaurant> restaurants = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Set<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Set<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
