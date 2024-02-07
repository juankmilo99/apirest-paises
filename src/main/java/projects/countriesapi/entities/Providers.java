package projects.countriesapi.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "providers")
public class Providers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
