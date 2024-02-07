package projects.countriesapi.entities;


import jakarta.persistence.*;


@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;

    private String name;

    private String flag;

    public Country(long id, String code, String name, String flag) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.flag = flag;
    }

    public Country() {
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getFlag() {
        return flag;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }}