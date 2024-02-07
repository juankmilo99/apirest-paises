package projects.countriesapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRoles {

@EmbeddedId
    private UserRolesId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JsonIgnoreProperties( {"hibernateLazyInitializer", "handler"})
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("roleId")
    @JsonIgnoreProperties( {"hibernateLazyInitializer", "handler"})
    private Roles role;

    public UserRolesId getId() {
        return id;
    }

    public void setId(UserRolesId id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}


