package projects.countriesapi.services.impl;

import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.countriesapi.entities.Roles;
import projects.countriesapi.entities.UserRoles;
import projects.countriesapi.entities.Users;
import projects.countriesapi.repository.RolesRepository;
import projects.countriesapi.repository.UserRolesRepository;
import projects.countriesapi.repository.UsersRepository;
import projects.countriesapi.response.UserRolesResponseRest;
import projects.countriesapi.services.UserRolesService;

import java.util.List;


@Service
public class UserRolesServiceImpl implements UserRolesService {
    private static final Logger log = LoggerFactory.getLogger(UserRolesServiceImpl.class);
    
    @Autowired
    private UserRolesRepository userRolesRepository;


    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<UserRolesResponseRest> buscarUserRoles() {

        UserRolesResponseRest response = new UserRolesResponseRest();

        try {

            List<UserRoles> usersRoles = userRolesRepository.findAll();

            response.getUserRolesResponse().setUserRoles(usersRoles);
            response.setMetadata("Respuesta ok", "200", "Respuesta exitosa");
        } catch (Exception e) {

            response.setMetadata("Respuesta nok", "-1", "Error al consultar usuarios");
            log.error("error al consultar usuarios: ", e.getMessage());
            e.getStackTrace();
            return new ResponseEntity<UserRolesResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<UserRolesResponseRest>(response, HttpStatus.OK); //devuelve 200
    }
    
}
