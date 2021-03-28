package restaurants.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "RESTAURANT")
@Getter @Setter
public class Restaurant {

    public Restaurant(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "restaurant")
    private List<Employee> emplyees = new ArrayList<>();

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
}