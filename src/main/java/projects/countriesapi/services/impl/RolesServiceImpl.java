package projects.countriesapi.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.countriesapi.entities.Roles;
import projects.countriesapi.repository.RolesRepository;
import projects.countriesapi.response.RolesResponseRest;
import projects.countriesapi.services.RolesService;

import java.util.List;
@Service
public class RolesServiceImpl implements RolesService {

    private static final Logger log = LoggerFactory.getLogger(RolesServiceImpl.class);

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<RolesResponseRest> buscarRoles() {

        RolesResponseRest response = new RolesResponseRest();

        try {
            List<Roles> roles = rolesRepository.findAll();
            response.getRolesResponse().setRoles(roles);
            response.setMetadata("Respuesta ok", "200", "Respuesta exitosa");
        } catch (Exception e) {

            response.setMetadata("Respuesta nok", "-1", "Error al consultar providers");
            log.error("error al consultar providers: ", e.getMessage());
            e.getStackTrace();
            return new ResponseEntity<RolesResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<RolesResponseRest>(response, HttpStatus.OK); //devuelve 200
    }
}
