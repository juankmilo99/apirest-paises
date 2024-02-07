package projects.countriesapi.response;

import projects.countriesapi.entities.UserRoles;

import java.util.List;

public class UserRolesResponse {
    private List<UserRoles> userRoles;

    public List<UserRoles> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRoles> userRoles) {
        this.userRoles = userRoles;
    }
}
