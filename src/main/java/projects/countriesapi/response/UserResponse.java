package projects.countriesapi.response;

import org.apache.catalina.User;
import projects.countriesapi.entities.Users;

import java.util.List;

public class UserResponse {
    private List<Users> users;

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
