package projects.countriesapi.services;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import projects.countriesapi.response.UserRolesResponseRest;

public interface UserRolesService {

    public ResponseEntity<UserRolesResponseRest> buscarUserRoles();
}
