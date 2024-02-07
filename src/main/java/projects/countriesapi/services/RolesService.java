package projects.countriesapi.services;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import projects.countriesapi.response.RolesResponseRest;

public interface RolesService {

    public ResponseEntity<RolesResponseRest> buscarRoles();
}
