package projects.countriesapi.response;

import projects.countriesapi.entities.Roles;

import java.util.List;

public class RolesResponse {
    private List<Roles> roles;

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
}
