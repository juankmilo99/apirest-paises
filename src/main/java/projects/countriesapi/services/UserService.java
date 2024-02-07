package projects.countriesapi.services;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import projects.countriesapi.response.UserResponseRest;

public interface UserService {

    public ResponseEntity<UserResponseRest> buscarUsers();
}
